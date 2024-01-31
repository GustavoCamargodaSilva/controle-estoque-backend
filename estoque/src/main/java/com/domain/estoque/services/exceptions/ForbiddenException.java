package com.domain.estoque.services.exceptions;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String msg, HttpStatus forbidden){
        super(msg);
    }
}
