package com.revature.book.service;

import com.revature.book.data.CartRepository;
import com.revature.book.entity.Book;
import com.revature.book.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    BookService bookService;

    // create a cart (empty)
    public Cart createCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cart;
    }

    // add a particular book to a particular cart
    public Cart addBookToCart(Long bookId, Long cartId) {
        Cart cartDB = cartRepository.findById(cartId).get();
        Book book = bookService.get_book_by_id(bookId);
        cartDB.addBook(book);
        cartRepository.save(cartDB);
        return cartDB;
    }

    // get books for a particular cart
    public Set<Book> viewBooksInCart(Long cartId) {
        Cart cartDB = cartRepository.findById(cartId).get();
        return cartDB.getBooks();
    }
}
