package com.revature.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data // getters and setters
@AllArgsConstructor
@ToString
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    // set up our one to many relationship:
    @OneToMany(targetEntity = Book.class, cascade =  CascadeType.ALL)
    // each book will have a cart that it belongs to:
    @JoinColumn(name = "cart_fk", referencedColumnName = "id")
    private Set<Book> books;

    // initialize our books to be an empty set:
    public Cart() {
        this.books = new HashSet<>();
    }

    // given a book, add to the cart:
    public void addBook(Book book) {
        this.books.add(book);
    }
}
