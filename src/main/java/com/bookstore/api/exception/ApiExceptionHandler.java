package com.bookstore.api.exception;

import com.bookstore.api.model.vo.ErrorVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorVO> handleEntity(EntityNotFoundException ex) {
        return ResponseEntity.status(ex.getError().getStatusCode()).body(ex.getError());
    }

}
