// FileTagRepository.java
package com.example.file.repository;

import com.example.file.entities.FileTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTagRepository extends JpaRepository<FileTag, Long> {

}
