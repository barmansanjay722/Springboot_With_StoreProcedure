package com.example.procedureRestApiSpringboot.model.res;


import com.example.procedureRestApiSpringboot.data.entity.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class GetAllBookResponse {

    public List<Book> getAllBooks;
}
