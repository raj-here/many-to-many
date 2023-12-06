// FileDetailsController.java
package com.example.file.controller;

import com.example.file.dto.FileDetailsDTO;
import com.example.file.dto.FileDetailsWithTagsDTO;
import com.example.file.entities.FileDetailsEntity;
import com.example.file.service.FileDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/file-details")
public class FileDetailsController {

    private final FileDetailsService fileDetailsService;

    @Autowired
    public FileDetailsController(FileDetailsService fileDetailsService) {
        this.fileDetailsService = fileDetailsService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<FileDetailsDTO>> listFileDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        try {
            Page<FileDetailsDTO> fileDetailsPage = fileDetailsService.getAllFileDetails(PageRequest.of(page, size));
            return new ResponseEntity<>(fileDetailsPage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{fileId}")
    public FileDetailsWithTagsDTO getFileDetailsWithTags(@PathVariable Long fileId) {
        return fileDetailsService.getFileDetailsWithTags(fileId);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFileDetails(@RequestBody FileDetailsEntity fileDetailsEntity) {
        try {
            FileDetailsEntity savedFileDetails = fileDetailsService.saveFileDetails(fileDetailsEntity);
            return new ResponseEntity<>("File details saved successfully with ID: " + savedFileDetails.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
