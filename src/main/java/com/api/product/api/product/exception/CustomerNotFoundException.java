package com.api.product.api.product.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
