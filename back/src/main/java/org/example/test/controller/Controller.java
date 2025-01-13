package org.example.test.controller;



import org.example.test.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")


public class Controller {
    @Autowired
    IService iService;






    @PostMapping("/calculate")
    public ResponseEntity<Integer> calculateSum(@RequestBody List<String> lines) {
        int result = iService.calculateSum(lines);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/upload")
    public ResponseEntity<Integer> calculateSumFromFile(@RequestParam("file") MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("calibration", ".txt");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(file.getBytes());
        }

        int result = iService.calculateSumFromFile(tempFile.getAbsolutePath());

        tempFile.delete();

        return ResponseEntity.ok(result);
    }


}






