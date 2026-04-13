package com.example.hexagonal.domain.port.out;

import com.example.hexagonal.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    List<Producto> buscarTodos();
    void eliminar(Long id);
}
