package com.rafael.notesSpringNew.notesSpringNew.printToFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import org.springframework.stereotype.Component;

@Component
public class SaveToJson implements SaveToFile {

    @Override
    public void printTofile(String data, String id) {
        String fileName = "note_id_" + id + ".json";
        Path path = Paths.get(fileName);
        try 
            {  
                Path p = Files.createFile(path);   
            } 
        catch (IOException e) {}
        
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(data);
            myWriter.close();
        }
        catch (IOException e) {}  
        
        System.out.println("hello ajax " + data);
    }
    
}
