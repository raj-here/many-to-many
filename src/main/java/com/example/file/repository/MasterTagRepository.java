// MasterTagRepository.java
package com.example.file.repository;

import com.example.file.entities.MasterTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasterTagRepository extends JpaRepository<MasterTag, Long> {
    Optional<MasterTag> findByTagName(String tagName);
}
