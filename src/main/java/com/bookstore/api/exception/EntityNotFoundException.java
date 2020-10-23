package com.bookstore.api.exception;

import com.bookstore.api.model.enums.ErrorEnum;
import com.bookstore.api.model.vo.ErrorVO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private ErrorVO error;

    public EntityNotFoundException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.error = new ErrorVO(errorEnum.getErrorCode(), errorEnum.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
