package com.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please check the offer format")
public class InvalidOfferException extends RuntimeException
{
    private static final long serialVersionUID = 1L;


    public InvalidOfferException(String message)
    {
        super(message);
    }
}
