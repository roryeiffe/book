package com.revature.book.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Lombok to make our lives easier:
@NoArgsConstructor
@AllArgsConstructor
@Data
// specify that book will be an object in the database:
@Entity
public class Book {
    // this will be the primary key of the book class:
    @Id
    // auto-generate ids (like serial in psql)
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String description;
    private int year;

    // constructor with no id:
    public Book(String name, String author, String description, int year) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
    }

}
