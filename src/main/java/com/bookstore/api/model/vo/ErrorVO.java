package com.bookstore.api.model.vo;

import com.bookstore.api.model.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorVO {

    private String errorCode;
    private String message;
    private Integer statusCode;
}
