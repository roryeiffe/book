package com.revature.book.controller;

import com.revature.book.entity.Book;

import com.revature.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// we can access this from anywhere, if we don't have this, we will be blocked by CORS:
@CrossOrigin(origins = "*")
// This is a controller that we're going to put GET, PUT, POST, DELETE requests in:
@RestController
// this is a class level annotation, states that any request that we define here has to be prefaced by "/books":
@RequestMapping("/books")
public class BookController {

    // this will automatically "wire" or connect te service to this class:
    @Autowired
    BookService bookService;

    // @PostMapping("/add") different syntax for the same thing
    @RequestMapping(value = "", method = RequestMethod.POST)
    // take the book object in the request body and pass it in as a parameter to this method:
    public Book add_book(@RequestBody Book book){
        return bookService.add_book(book);
    }

    @GetMapping("")
    public List<Book> get_all_books() {
        return bookService.get_all_books();
    }

    @GetMapping("/special")
    public List<Book> get_all_books_custom(@RequestParam("flag") String flag) {
        return bookService.get_books_custom(flag);
    }

    @GetMapping("/{id}")
    public Book get_book_by_id(@PathVariable("id") Long id) {
        return bookService.get_book_by_id(id);
    }

    @PutMapping("/{id}")
    public Book update_book(@RequestBody Book book, @PathVariable("id")long id) {
        System.out.println(book);
        return bookService.update_book(book, id);
    }

    @DeleteMapping("/{id_to_delete}")
    public void delete_book(@PathVariable("id_to_delete") long id) {
        bookService.delete_book(id);
    }

}
