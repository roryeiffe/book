package com.revature.book.service;

import com.revature.book.BookApplication;
import com.revature.book.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.PropertyResourceBundle;

@SpringBootTest
// configure this class to use application-test.proprties:
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookTest {

    @Autowired
    BookService bookService;

    @Test
    public void addBook() {
        Book book = new Book("name 1", "author 1", "description 1", 2000);
        bookService.add_book(book);
        Assertions.assertEquals(1, book.getId());
    }

    @Test
    public void addBook2() {
        Book book = new Book("name 1", "author 1", "description 1", 2000);
        bookService.add_book(book);
        Assertions.assertEquals(1, book.getId());
    }
}
