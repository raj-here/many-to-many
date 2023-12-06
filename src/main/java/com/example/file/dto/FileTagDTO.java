package com.example.file.dto;

import lombok.Data;

@Data
public class FileTagDTO {

    private Long id;
    private String tagName;
    private String tagValue;

    private FileTagDTO(Builder builder) {
        this.id = builder.id;
        this.tagName = builder.tagName;
        this.tagValue = builder.tagValue;
    }

    public static class Builder {
        private Long id;
        private String tagName;
        private String tagValue;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder tagValue(String tagValue) {
            this.tagValue = tagValue;
            return this;
        }

        public Builder tagName(String tagName) {
            this.tagName = tagName;
            return this;
        }

        public FileTagDTO build() {
            return new FileTagDTO(this);
        }
    }
}
