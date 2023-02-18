package com.example.procedureRestApiSpringboot.model.req;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {

    public String name;

    public String author;
}
