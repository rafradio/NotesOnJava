/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.dao;

import com.rafael.notesSpringNew.notesSpringNew.models.Note;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesDao {
    private List<Note> notes = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public NotesDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Note> main(){
        return jdbcTemplate.query("select * from javanotes", new NoteMapper());
    }
    
    public void saveNote(Note note) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        note.setData(date);
        jdbcTemplate.update("insert into javanotes (title, body, data) values(?,?,?)",
                note.getTitle(), note.getBody(), note.getData());
//        System.out.println("Меня зовут " + note.getTitle() + "\n");
//        System.out.println("тело: " + note.getBody() + "\n");
    }
    
    public Note showNote(int id) {
        return jdbcTemplate.query("SELECT * FROM javanotes WHERE id=?", new Object[]{id}, new NoteMapper())
                .stream().findAny().orElse(null);
        
    }
    
    public void editNote(Note note, int id) {
        Date date = Calendar.getInstance().getTime();
        note.setData(date);
        jdbcTemplate.update("UPDATE javanotes SET title=?, body=?, data=? WHERE id=?",
                note.getTitle(), note.getBody(), note.getData(), id);
        
    }
    
    public void deleteNote(int id) {
        jdbcTemplate.update("DELETE FROM javanotes WHERE id=?", id);
    }
}
