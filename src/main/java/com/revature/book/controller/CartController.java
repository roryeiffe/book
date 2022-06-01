package com.revature.book.controller;

import com.revature.book.dto.BookCartIdObject;
import com.revature.book.entity.Book;
import com.revature.book.entity.Cart;
import com.revature.book.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("")
    public Cart createCart() {
        return cartService.createCart();
    }

    @PutMapping("")
    public Cart addBookToCart(@RequestBody BookCartIdObject bookCartIdObject) {
        Long bookId = bookCartIdObject.getBookId();
        Long cartId = bookCartIdObject.getCartId();
        return cartService.addBookToCart(bookId, cartId);
    }

    @GetMapping("/{id}")
    public Set<Book> viewBooksInCart(@PathVariable("id") Long id) {
        return cartService.viewBooksInCart(id);
    }

}
