package com.josemeurer.store.services.exceptions;

public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(Object id) {
        super("Resouce not found. Id: " + id);
    }
}
