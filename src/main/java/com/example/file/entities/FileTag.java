package com.example.file.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "file_tags")
@NoArgsConstructor
@AllArgsConstructor
public class FileTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private MasterTag tag;

    @Column(name = "tag_value")
    private String tagValue;

    public FileTag(MasterTag tag, String tagValue) {
        this.tag = tag;
        this.tagValue = tagValue;
    }
}
