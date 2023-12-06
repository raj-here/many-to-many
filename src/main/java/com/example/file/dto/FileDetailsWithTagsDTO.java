package com.example.file.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
public class FileDetailsWithTagsDTO {

    private Long id;
    private String mimeType;
    private String name;
    private String location;
    private String type;
    private String uploadedBy;
    private Long size;
    private String status;
    private ZonedDateTime lastModified;
    private Set<FileTagDTO> fileTags;

    private FileDetailsWithTagsDTO(Builder builder) {
        this.id = builder.id;
        this.mimeType = builder.mimeType;
        this.name = builder.name;
        this.location = builder.location;
        this.type = builder.type;
        this.uploadedBy = builder.uploadedBy;
        this.size = builder.size;
        this.status = builder.status;
        this.lastModified = builder.lastModified;
        this.fileTags = builder.fileTags;
    }

    public static class Builder {
        private Long id;
        private String mimeType;
        private String name;
        private String location;
        private String type;
        private String uploadedBy;
        private Long size;
        private String status;
        private ZonedDateTime lastModified;
        private Set<FileTagDTO> fileTags;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder uploadedBy(String uploadedBy) {
            this.uploadedBy = uploadedBy;
            return this;
        }

        public Builder size(Long size) {
            this.size = size;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder lastModified(ZonedDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public Builder fileTags(Set<FileTagDTO> fileTags) {
            this.fileTags = fileTags;
            return this;
        }

        public FileDetailsWithTagsDTO build() {
            return new FileDetailsWithTagsDTO(this);
        }
    }
}
