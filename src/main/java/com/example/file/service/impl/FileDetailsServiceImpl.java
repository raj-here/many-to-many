// FileDetailsServiceImpl.java
package com.example.file.service.impl;

import com.example.file.dto.FileDetailsDTO;
import com.example.file.dto.FileDetailsWithTagsDTO;
import com.example.file.dto.FileTagDTO;
import com.example.file.entities.FileDetailsEntity;
import com.example.file.entities.FileTag;
import com.example.file.repository.FileDetailsRepository;
import com.example.file.service.FileDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileDetailsServiceImpl implements FileDetailsService {

    private final FileDetailsRepository fileDetailsRepository;

    @Autowired
    public FileDetailsServiceImpl(FileDetailsRepository fileDetailsRepository) {
        this.fileDetailsRepository = fileDetailsRepository;
    }

    @Override
    public Page<FileDetailsDTO> getAllFileDetails(Pageable pageable) {

        Page<FileDetailsEntity> fileDetailsPage = fileDetailsRepository.findAll(pageable);

        return fileDetailsPage.map(this::convertToFileDetailsDTO);
    }



    private FileDetailsDTO convertToFileDetailsDTO(FileDetailsEntity fileDetailsEntity) {
        return new FileDetailsDTO.Builder()
            .id(fileDetailsEntity.getId())
            .mimeType(fileDetailsEntity.getMimeType())
            .name(fileDetailsEntity.getName())
            .location(fileDetailsEntity.getLocation())
            .type(fileDetailsEntity.getType())
            .uploadedBy(fileDetailsEntity.getUploadedBy())
            .size(fileDetailsEntity.getSize())
            .status(fileDetailsEntity.getStatus())
            .lastModified(fileDetailsEntity.getLastModified())
            .build();
    }

    @Override
    public FileDetailsEntity saveFileDetails(FileDetailsEntity fileDetailsEntity) {
        // Additional validation or business logic can be added here
        return fileDetailsRepository.save(fileDetailsEntity);
    }

    @Override
    public FileDetailsWithTagsDTO getFileDetailsWithTags(Long fileId) {
        FileDetailsEntity fileDetailsEntity = fileDetailsRepository.findById(fileId)
            .orElseThrow(() -> new EntityNotFoundException("FileDetailsEntity not found with id: " + fileId));

        return convertToFileDetailsWithTagsDTO(fileDetailsEntity);
    }

    private FileDetailsWithTagsDTO convertToFileDetailsWithTagsDTO(FileDetailsEntity fileDetailsEntity) {
        return new FileDetailsWithTagsDTO.Builder()
            .id(fileDetailsEntity.getId())
            .mimeType(fileDetailsEntity.getMimeType())
            .name(fileDetailsEntity.getName())
            .location(fileDetailsEntity.getLocation())
            .type(fileDetailsEntity.getType())
            .uploadedBy(fileDetailsEntity.getUploadedBy())
            .size(fileDetailsEntity.getSize())
            .status(fileDetailsEntity.getStatus())
            .lastModified(fileDetailsEntity.getLastModified())
            .fileTags(convertToFileTagDTOSet(fileDetailsEntity.getFileTags()))
            .build();
    }

    private Set<FileTagDTO> convertToFileTagDTOSet(Set<FileTag> fileTagEntities) {
        return fileTagEntities.stream()
            .map(fileTagEntity -> new FileTagDTO.Builder()
                .id(fileTagEntity.getId())
                .tagValue(fileTagEntity.getTagValue())
                .tagName(fileTagEntity.getTag().getTagName())
                .build())
            .collect(Collectors.toSet());
    }
}
