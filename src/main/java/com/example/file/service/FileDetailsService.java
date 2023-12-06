// FileDetailsService.java
package com.example.file.service;

import com.example.file.dto.FileDetailsDTO;
import com.example.file.dto.FileDetailsWithTagsDTO;
import com.example.file.entities.FileDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FileDetailsService {
    Page<FileDetailsDTO> getAllFileDetails(Pageable pageable);

    FileDetailsEntity saveFileDetails(FileDetailsEntity fileDetailsEntity);

    FileDetailsWithTagsDTO getFileDetailsWithTags(Long fileId);
}
