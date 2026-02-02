package com.assignment.restApi.controller;

import com.assignment.restApi.services.implementations.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/{Id}/profile-img")
    public ResponseEntity<Void> uploadProfileImage(@PathVariable Long Id, @RequestParam("file") MultipartFile file) throws IOException {
        String filePath = fileService.saveProfileImage(file, Id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{Id}/profile-img")
    public ResponseEntity<Resource> getProfileImage(@PathVariable Long Id) throws MalformedURLException {
        return fileService.getProfileImage(Id);
    }
}
