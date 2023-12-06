package com.example.file.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "master_tags")
@NoArgsConstructor
@AllArgsConstructor
public class MasterTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "tag_name", unique = true)
    private String tagName;
}
