package com.portfolio.myportfolio.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @GetMapping("/upload")
    public String uploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file,
                               Model model) {

        try {
            // Upload folder create if not exist
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Save pdf as resume.pdf
            Path path = Paths.get(UPLOAD_DIR + "resume.pdf");
            Files.write(path, file.getBytes());

            model.addAttribute("uploaded", true);
            model.addAttribute("message", "Resume uploaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("uploaded", false);
            model.addAttribute("message", "Error uploading file!");
        }

        return "upload";
    }

    @GetMapping("/resume")
    public ResponseEntity<Resource> downloadResume() {

        try {
            File file = new File(UPLOAD_DIR + "resume.pdf");
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            InputStreamResource resource =
                    new InputStreamResource(new FileInputStream(file));

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=resume.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .contentLength(file.length())
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
