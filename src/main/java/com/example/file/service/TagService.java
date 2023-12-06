package com.example.file.service;


import com.example.file.dto.TagAssociationRequestDTO;

public interface TagService {
    void addMasterTagAndAssociateWithFile(TagAssociationRequestDTO requestDTO);
}
