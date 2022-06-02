package com.revature.book.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.book.entity.Book;
import com.revature.book.service.BookService;
import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ConfigurationProperties(prefix="spring.secondDatasource")
public class BookControllerTest {

    @Autowired
    private BookController bookController;
    @Autowired
    private BookService bookService;

    private static RestTemplate restTemplate;
    private static HttpHeaders headers;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String bookUrl = "http://localhost:9001/books";

//    @BeforeEach
//    public void init() {
//        bookService.add_book(new Book("title 1", "author 1", "desc 1", 1));
//        bookService.add_book(new Book("title 2", "author 2", "desc 2", 2));
//        bookService.add_book(new Book("title 3", "author 3", "desc 3", 3));
//    }
//
//    @BeforeAll
//    public static void setUp() {
//        restTemplate = new RestTemplate();
//    }
//
//    @Test
//    public void contextLoads() throws Exception {
//        Assertions.assertNotNull(bookController);
//    }
//
//    @Test
//    public void testGetBook() throws Exception {
//        assertThat(this.restTemplate.getForObject(bookUrl + "/1",
//                String.class)).contains("{\"id\":1,\"name\":\"title 1\",\"author\":\"author 1\",\"description\":\"desc 1\",\"year\":1}");
//    }
//
//    @Test
//    public void testGetAllBooks() throws Exception {
//        assertThat(this.restTemplate.getForObject(bookUrl,
//                String.class)).contains("[{\"id\":1,\"name\":\"title 1\",\"author\":\"author 1\",\"description\":\"desc 1\",\"year\":1},{\"id\":2,\"name\":\"title 2\",\"author\":\"author 2\",\"description\":\"desc 2\",\"year\":2},{\"id\":3,\"name\":\"title 3\",\"author\":\"author 3\",\"description\":\"desc 3\",\"year\":3}]");
//    }
//
//    @Test
//    public void testPostBook() throws Exception {
//        JSONObject bookJsonObject = new JSONObject();
//        try {
//            bookJsonObject.put("name", "John");
//            bookJsonObject.put("author", "John");
//            bookJsonObject.put("description", "John");
//            bookJsonObject.put("year", 2012);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        HttpEntity<String> request = new HttpEntity<String>(bookJsonObject.toString(), headers);
//        String personResultAsJsonStr = restTemplate.postForObject(bookUrl, request, String.class);
//        try {
//            JsonNode root = objectMapper.readTree(personResultAsJsonStr);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        Book book = restTemplate.postForObject(bookUrl, request, Book.class);
//
//        System.out.println(book);
//    }
}
