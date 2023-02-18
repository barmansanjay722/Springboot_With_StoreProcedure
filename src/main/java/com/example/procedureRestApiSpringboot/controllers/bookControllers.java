package com.example.procedureRestApiSpringboot.controllers;

import com.example.procedureRestApiSpringboot.model.req.AddBookRequest;
import com.example.procedureRestApiSpringboot.model.res.AddBookResponse;
import com.example.procedureRestApiSpringboot.model.res.GetAllBookResponse;
import com.example.procedureRestApiSpringboot.service.bookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class bookControllers {

    @Autowired
    private bookService bookService;


    @PostMapping("/addBook")
    public ResponseEntity<AddBookResponse> addBook(@Valid @RequestBody AddBookRequest addBookRequest) {
        return bookService.addBook(addBookRequest);
    }

    @GetMapping("/books")
    public ResponseEntity<GetAllBookResponse> getBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity updateBook(@PathVariable int id, @RequestBody AddBookRequest addBookRequest) {
        return bookService.updateBook(id,addBookRequest);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<GetAllBookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/deletebook/{id}")
    public ResponseEntity<AddBookResponse> bookdelete(@PathVariable int id) {
        return bookService.deletebook(id);
    }
}
