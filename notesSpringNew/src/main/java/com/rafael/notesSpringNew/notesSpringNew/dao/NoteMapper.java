/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.dao;

import com.rafael.notesSpringNew.notesSpringNew.models.Note;
//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.RowMapper;

public class NoteMapper implements RowMapper<Note> {

    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Note note = new Note();
        note.setId(rs.getInt("id"));
        note.setTitle(rs.getString("title"));
        note.setBody(rs.getString("body"));
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        String newdate = rs.getString("data");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"); 
        Date datenew = null;
//        try { 
//            datenew = formatter.parse(newdate);
//        } catch (ParseException ex) {
//            Logger.getLogger(NoteMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Date date = rs.getDate("data");
        System.out.println("Проверяем дату " + datenew + "\n");
//        Date date1 = rs.getDate("data", "yyyy-mm-dd HH:mm:ss");
//        LocalDateTime data = LocalDateTime.parse((String) rs.getDate("data"), myFormatObj);
        note.setData(date);
        return note;
    }
    
}
