// TagController.java
package com.example.file.controller;

import com.example.file.dto.TagAssociationRequestDTO;
import com.example.file.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/new-tag-value")
    public ResponseEntity<String> associateTag(@RequestBody TagAssociationRequestDTO requestDTO) {
        try {
            tagService.addMasterTagAndAssociateWithFile(requestDTO);
            return new ResponseEntity<>("Tag associated successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
