package com.example.file.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "file_details")
@NoArgsConstructor
@AllArgsConstructor
public class FileDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private FileDetailsEntity parent;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "name")
    private String name;

    @Column(name = "Location")
    private String location;

    @Column(name = "type")
    private String type;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    @Column(name = "size")
    private Long size;

    @Column(name = "status")
    private String status;

    @Column(name = "last_modified")
    private ZonedDateTime lastModified;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private Set<FileTag> fileTags = new HashSet<>();
}
