package com.example.file.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class FileDetailsDTO {

    private Long id;
    private String mimeType;
    private String name;
    private String location;
    private String type;
    private String uploadedBy;
    private Long size;
    private String status;
    private ZonedDateTime lastModified;

    // Omit the fileTags field

    // Private constructor to enforce the use of the builder
    private FileDetailsDTO() {
    }

    // Builder class
    public static class Builder {

        private final FileDetailsDTO fileDetailsDTO;

        public Builder() {
            fileDetailsDTO = new FileDetailsDTO();
        }

        public Builder id(Long id) {
            fileDetailsDTO.setId(id);
            return this;
        }

        public Builder mimeType(String mimeType) {
            fileDetailsDTO.setMimeType(mimeType);
            return this;
        }

        public Builder name(String name) {
            fileDetailsDTO.setName(name);
            return this;
        }

        public Builder location(String location) {
            fileDetailsDTO.setLocation(location);
            return this;
        }

        public Builder type(String type) {
            fileDetailsDTO.setType(type);
            return this;
        }

        public Builder uploadedBy(String uploadedBy) {
            fileDetailsDTO.setUploadedBy(uploadedBy);
            return this;
        }

        public Builder size(Long size) {
            fileDetailsDTO.setSize(size);
            return this;
        }

        public Builder status(String status) {
            fileDetailsDTO.setStatus(status);
            return this;
        }

        public Builder lastModified(ZonedDateTime lastModified) {
            fileDetailsDTO.setLastModified(lastModified);
            return this;
        }

        public FileDetailsDTO build() {
            return fileDetailsDTO;
        }
    }
}
