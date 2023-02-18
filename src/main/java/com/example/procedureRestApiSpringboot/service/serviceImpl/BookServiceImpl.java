package com.example.procedureRestApiSpringboot.service.serviceImpl;


import com.example.procedureRestApiSpringboot.data.entity.Book;
import com.example.procedureRestApiSpringboot.data.repo.BookRepo;
import com.example.procedureRestApiSpringboot.model.req.AddBookRequest;
import com.example.procedureRestApiSpringboot.model.res.AddBookResponse;
import com.example.procedureRestApiSpringboot.model.res.GetAllBookResponse;
import com.example.procedureRestApiSpringboot.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements bookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public ResponseEntity<AddBookResponse> addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setName(addBookRequest.name);
        book.setAuthor(addBookRequest.author);
        bookRepo.save(book);
        return new ResponseEntity<>(new AddBookResponse("book successfully added"), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<GetAllBookResponse> getAllBooks() {
        GetAllBookResponse getAllBookResponse = new GetAllBookResponse();
        try {
            List<Book> bookList = bookRepo.getAllBooks();
            if (!bookList.isEmpty()) {
                getAllBookResponse.setGetAllBooks(bookList);
            }
        } catch (DataAccessException dbe) {
            System.out.println("Error:" + dbe);
        }
        return new ResponseEntity<>(getAllBookResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateBook(int id, AddBookRequest addBookRequest) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isPresent()){
            book.get().setName(addBookRequest.name);
            book.get().setAuthor(addBookRequest.author);
            bookRepo.save(book.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AddBookResponse> deletebook(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isPresent()) {
            book.get().setActive(false);
            bookRepo.save(book.get());
        }
        return new ResponseEntity<>(new AddBookResponse("deleted successfully"),HttpStatus.OK);
    }

//    @Override
//    public String getBookId(int id) {
//        return bookRepo.findbyidbook(id);
//    }
}
