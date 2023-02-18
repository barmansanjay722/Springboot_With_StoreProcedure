package com.example.procedureRestApiSpringboot.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Author is mandatory")
    private String author;

    @Builder.Default
    @ColumnDefault("true")
    private Boolean active;

    public Book(int id, String name, String author, Boolean active) {
        Id = id;
        this.name = name;
        this.author = author;
        this.active = active;
    }

    public Book() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
