/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.controllers;

import com.rafael.notesSpringNew.notesSpringNew.dao.NotesDao;
import com.rafael.notesSpringNew.notesSpringNew.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class NotesController {
    private NotesDao notesDao;

    @Autowired
    public NotesController(NotesDao notesDao) {
        this.notesDao = notesDao;
    }
    
    
    
    @GetMapping("/index")
    public String showAll(Model model) {
        model.addAttribute("note", new Note());
        return "notes/index";
    }
    
    @PostMapping("/index")
    public String createNote(@ModelAttribute("note") Note note) {
        this.notesDao.saveNote(note);
        return "redirect:/index";
    }
    
}
