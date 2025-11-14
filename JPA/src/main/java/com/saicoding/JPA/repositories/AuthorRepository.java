package com.saicoding.JPA.repositories;

import com.saicoding.JPA.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    //List<Author> findByNamedQuery(@Param("age") int age);


    // update Author a set a.age = 22 where a.id =2
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthorAgeById(int age, int id);


    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);



    // select * from authors where first_name = ''
    List<Author> findAllByFirstName(String fn);

    // select * from authors where first_name = '' (case insensitive)
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from authors where first_name like '%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from authors where first_name like 'fn%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from authors where first_name like '%fn'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    //select * from author where first_name in ('ali', 'sai', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fns);
}
