package com.revature.book.service;

import com.revature.book.BookApplication;
import com.revature.book.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookTest {

    @Autowired
    BookService bookService;

    @Test
    public void testGetBook() {
//        List<Book> books = bookService.get_all_books();
//        Assertions.assertEquals("Book(id=44, name=, author=, description=, year=0)", books.get(0).toString());
    }
}
