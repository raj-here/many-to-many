// FileDetailsRepository.java
package com.example.file.repository;

import com.example.file.entities.FileDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDetailsRepository extends JpaRepository<FileDetailsEntity, Long> {

}
