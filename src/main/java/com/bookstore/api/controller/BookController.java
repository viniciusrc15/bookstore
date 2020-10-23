package com.bookstore.api.controller;

import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.vo.BookVO;
import com.bookstore.api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> findBookById(
            @RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok().body(bookService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookVO> findBookById(@PathVariable Long id) {
        BookVO book = bookService.findBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.save(book));
    }
}
