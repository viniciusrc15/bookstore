package com.bookstore.api.model.vo;

import com.bookstore.api.model.entity.Book;
import com.bookstore.api.model.entity.PublishingCompany;
import com.bookstore.api.model.entity.StatusBook;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookVO {

    private Long id;
    private String name;
    private PublishingCompanyVO publishingCompany;
    private StatusBook status;

    public BookVO(Book book, PublishingCompany publishingCompany) {
        this.id = book.getId();
        this.name = book.getName();
        this.publishingCompany = new PublishingCompanyVO(publishingCompany);
        this.status = book.getStatus();
    }

    public BookVO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.status = book.getStatus();
    }
}
