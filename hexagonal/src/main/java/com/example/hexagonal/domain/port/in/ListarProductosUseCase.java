package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.Producto;

import java.util.List;

public interface ListarProductosUseCase {
    List<Producto> listarTodos();
    Producto buscarPorId(Long id);
}
