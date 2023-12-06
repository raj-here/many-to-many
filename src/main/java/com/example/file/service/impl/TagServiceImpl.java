// TagServiceImpl.java
package com.example.file.service.impl;

import com.example.file.dto.TagAssociationRequestDTO;
import com.example.file.entities.FileDetailsEntity;
import com.example.file.entities.FileTag;
import com.example.file.entities.MasterTag;
import com.example.file.repository.FileDetailsRepository;
import com.example.file.repository.FileTagRepository;
import com.example.file.repository.MasterTagRepository;
import com.example.file.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImpl implements TagService {

    private final FileDetailsRepository fileDetailsRepository;
    private final MasterTagRepository masterTagRepository;
    private final FileTagRepository fileTagRepository;

    @Autowired
    public TagServiceImpl(
            FileDetailsRepository fileDetailsRepository,
            MasterTagRepository masterTagRepository,
            FileTagRepository fileTagRepository
    ) {
        this.fileDetailsRepository = fileDetailsRepository;
        this.masterTagRepository = masterTagRepository;
        this.fileTagRepository = fileTagRepository;
    }

    @Override
    @Transactional
    public void addMasterTagAndAssociateWithFile(TagAssociationRequestDTO requestDTO) {
        FileDetailsEntity fileDetailsEntity = fileDetailsRepository.findById(requestDTO.getFileId())
                .orElseThrow(() -> new IllegalArgumentException("FileDetailsEntity not found with id: " + requestDTO.getFileId()));

        MasterTag masterTag = masterTagRepository.findByTagName(requestDTO.getTagName())
                .orElseGet(() -> masterTagRepository.save(new MasterTag(null, requestDTO.getTagName())));

        FileTag fileTag = new FileTag(masterTag, requestDTO.getTagValue());
        fileTagRepository.save(fileTag);
        fileDetailsEntity.getFileTags().add(fileTag);
        fileDetailsRepository.save(fileDetailsEntity);
    }
}
