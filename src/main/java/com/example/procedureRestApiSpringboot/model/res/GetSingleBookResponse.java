package com.example.procedureRestApiSpringboot.model.res;

import com.example.procedureRestApiSpringboot.data.entity.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class GetSingleBookResponse {

    public Book getSingleBook;
}
