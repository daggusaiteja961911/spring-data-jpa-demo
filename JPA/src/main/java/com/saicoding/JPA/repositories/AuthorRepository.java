package com.saicoding.JPA.repositories;

import com.saicoding.JPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
