package com.revature.book.data;

import com.revature.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// we specify that our repository is for the book object with id's being stored as longs
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // the program knows that we want to find all books with years greater than whatever we pass in:
    public List<Book> findByYearGreaterThan(int year);
    public List<Book> findByYearLessThan(int year);

    // making our own custom query using postres syntax:
    @Query(value = "SELECT * FROM book where author = ?1", nativeQuery = true)
    public List<Book> findByAuthorName(String author);
}
