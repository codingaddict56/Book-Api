package com.example.book_api.controller;

import com.example.book_api.model.Book;
import com.example.book_api.service.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
client -> controller -> service -> Repo -> DB
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(service.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@Parameter String id){
        return service.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@Parameter String id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
