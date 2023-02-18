package com.example.procedureRestApiSpringboot.service;

import com.example.procedureRestApiSpringboot.model.req.AddBookRequest;
import com.example.procedureRestApiSpringboot.model.req.DeleteBookRequest;
import com.example.procedureRestApiSpringboot.model.res.AddBookResponse;
import com.example.procedureRestApiSpringboot.model.res.GetAllBookResponse;
import org.springframework.http.ResponseEntity;

public interface bookService {

    ResponseEntity<AddBookResponse> addBook(AddBookRequest addBookRequest);

    ResponseEntity<GetAllBookResponse> getAllBooks();

    ResponseEntity updateBook(int id, AddBookRequest addBookRequest);

    ResponseEntity<AddBookResponse>deletebook(int id);
}
