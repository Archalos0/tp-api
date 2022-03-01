package com.api.product.api.product.exception;

public class ContractNotFoundException extends RuntimeException{

    public ContractNotFoundException(Long id) {
        super("Could not find contract " + id);
    }
}
