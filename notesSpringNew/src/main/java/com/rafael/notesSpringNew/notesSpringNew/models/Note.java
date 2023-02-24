/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rafael.notesSpringNew.notesSpringNew.models;

import java.util.Date;  
import java.time.LocalDateTime;

public class Note {
    private int id;
    
    private String title;
    
    private String body;
    
    private Date data;

    public Note() {
        
    }

    public Note(int id, String title, String body, Date data) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.data = data;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
