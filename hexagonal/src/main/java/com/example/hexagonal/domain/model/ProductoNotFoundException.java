package com.example.hexagonal.domain.model;

public class ProductoNotFoundException extends RuntimeException {

    public ProductoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
