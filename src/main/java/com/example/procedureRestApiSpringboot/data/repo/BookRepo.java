package com.example.procedureRestApiSpringboot.data.repo;

import com.example.procedureRestApiSpringboot.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    @Procedure(value = "getAllBooks")
    List<Book> getAllBooks();
}
