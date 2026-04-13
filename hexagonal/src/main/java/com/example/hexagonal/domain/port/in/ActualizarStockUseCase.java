package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Producto;

public interface ActualizarStockUseCase {
    Producto reducirStock(Long id, int cantidad);
}
