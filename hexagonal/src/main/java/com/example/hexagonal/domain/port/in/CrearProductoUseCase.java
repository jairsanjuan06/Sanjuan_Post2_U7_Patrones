package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Producto;

public interface CrearProductoUseCase {
    Producto crear(Producto producto);
}
