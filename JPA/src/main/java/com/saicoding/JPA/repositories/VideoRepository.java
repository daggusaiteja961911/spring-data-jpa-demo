package com.saicoding.JPA.repositories;

import com.saicoding.JPA.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
