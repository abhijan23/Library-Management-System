package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Author;

public interface AuthorRepositories extends JpaRepository<Author, Long>{
    List<Author> findByName(String name);
    List<Author> findByBirthDate(String birthDate);
    List<Author> findByNationality(String nationality);
}