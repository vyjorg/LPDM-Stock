package com.lpdm.msstock.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFound extends RuntimeException{
    public StockNotFound(String s) {
        super(s);
    }

}





