package com.example.file.dto;

import lombok.Data;

@Data
public class TagAssociationRequestDTO {

    private Long fileId;
    private String tagName;
    private String tagValue;
}
