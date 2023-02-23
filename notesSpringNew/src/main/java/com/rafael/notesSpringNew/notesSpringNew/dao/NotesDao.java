/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.dao;

import com.rafael.notesSpringNew.notesSpringNew.models.Note;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class NotesDao {
    private List<Note> notes = new ArrayList<>();
    
    public void saveNote(Note note) {
        System.out.println("Меня зовут " + note.getTitle() + "\n");
        System.out.println("тело: " + note.getBody() + "\n");
    }
}
