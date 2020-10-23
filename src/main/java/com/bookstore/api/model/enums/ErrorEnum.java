package com.bookstore.api.model.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ErrorEnum {

    BOOK_NOT_FOUND("B001", "Book not found in bookstore"),
    PUBLISHING_NOT_FOUND("P001", "Publishing not found in bookstore");

    private String errorCode;
    private String message;

    ErrorEnum(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }
}
