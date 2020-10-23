package com.bookstore.api.service;

import com.bookstore.api.exception.EntityNotFoundException;
import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.enums.ErrorEnum;
import com.bookstore.api.model.repository.BookRepository;
import com.bookstore.api.model.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookVO findBookById(Long id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorEnum.BOOK_NOT_FOUND));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Page<Book> findAll(int page, int size) {
        return bookRepository.findBooksPagination(PageRequest.of(page, size));
    }
}
