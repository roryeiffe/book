package com.revature.book.service;

import com.revature.book.data.BookRepository;
import com.revature.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // automatically connects the bookRepository
    @Autowired
    BookRepository bookRepository;

    public Book add_book(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> get_all_books() {
        return bookRepository.findAll();
    }

    public List<Book> get_books_custom(String flag) {
        switch(flag){
            case "new":
                return bookRepository.findByYearGreaterThan(2000);
            case "old":
                return bookRepository.findByYearLessThan(2001);
            case "Dr. Suess":
                return bookRepository.findByAuthorName("Dr. Suess");
            default:
                // default, call our get all books service method:
                return get_all_books();
        }
    }


    public Book get_book_by_id(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book update_book(Book book, Long id) {
        Book bookDB = bookRepository.findById(id).get();
        bookDB.setName(book.getName());
        bookDB.setDescription(book.getDescription());
        bookDB.setAuthor(book.getAuthor());
        bookDB.setYear(book.getYear());
        bookRepository.save(bookDB);
        return bookDB;
    }

    public void delete_book(Long id) {
        bookRepository.deleteById(id);
    }

}
