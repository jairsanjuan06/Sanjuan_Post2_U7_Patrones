package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.domain.model.PrecioInvalidoException;
import com.example.hexagonal.domain.model.ProductoNotFoundException;
import com.example.hexagonal.domain.model.StockInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(ProductoNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler({PrecioInvalidoException.class, StockInsuficienteException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadRequest(RuntimeException ex) {
        return Map.of("error", ex.getMessage());
    }
}
