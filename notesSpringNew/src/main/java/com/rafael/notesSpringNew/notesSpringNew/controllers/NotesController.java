/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.controllers;

import com.rafael.notesSpringNew.notesSpringNew.dao.NotesDao;
import com.rafael.notesSpringNew.notesSpringNew.models.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("note", new Note());
        return "notes/new";
    }
    
    @PostMapping("/new")
    public String createNote(@ModelAttribute("note") Note note) {
        this.notesDao.saveNote(note);
        return "redirect:/main";
    }
    
    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Note> notes = this.notesDao.main();
        model.addAttribute("notes", notes);
        System.out.println("размер заметок " + notes.size() + "\n");
        return "notes/main";
    }
    
    @GetMapping("/note/{id}")
    public String showNote(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", this.notesDao.showNote(id));
        return "notes/edit"; 
    }
    
    @PostMapping("/{id}/edit")
    public String editNote(@ModelAttribute("note") Note note, @PathVariable("id") int id) {
        this.notesDao.editNote(note, id);
        return "redirect:/main";
    }
    
    @GetMapping("/test")
    public String test(Model model) {
//        model.addAttribute("note", new Note());
        return "notes/test";
    }
    
    @PostMapping("/{id}/delete")
    public String deleteNote(@ModelAttribute("note") Note note, @PathVariable("id") int id) {
        this.notesDao.deleteNote(id);
        return "redirect:/main";
    }
    
}
