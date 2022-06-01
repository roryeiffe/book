package com.revature.book;

import com.revature.book.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		Book book = new Book();
		SpringApplication.run(BookApplication.class, args);
	}

}
