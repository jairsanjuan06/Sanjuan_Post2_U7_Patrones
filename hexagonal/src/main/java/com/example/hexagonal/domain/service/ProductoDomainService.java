package com.example.hexagonal.domain.service;

import com.example.hexagonal.domain.model.PrecioInvalidoException;
import com.example.hexagonal.domain.model.Producto;
import com.example.hexagonal.domain.model.ProductoNotFoundException;
import com.example.hexagonal.domain.port.in.ActualizarStockUseCase;
import com.example.hexagonal.domain.port.in.CrearProductoUseCase;
import com.example.hexagonal.domain.port.in.ListarProductosUseCase;
import com.example.hexagonal.domain.port.out.ProductoRepositoryPort;

import java.math.BigDecimal;
import java.util.List;

public class ProductoDomainService
        implements CrearProductoUseCase, ListarProductosUseCase, ActualizarStockUseCase {

    private final ProductoRepositoryPort repositoryPort;

    public ProductoDomainService(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Producto crear(Producto producto) {
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor a cero");
        }
        return repositoryPort.guardar(producto);
    }

    @Override
    public List<Producto> listarTodos() {
        return repositoryPort.buscarTodos();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto " + id + " no encontrado"));
    }

    @Override
    public Producto reducirStock(Long id, int cantidad) {
        Producto producto = buscarPorId(id);
        producto.reducirStock(cantidad);
        return repositoryPort.guardar(producto);
    }
}
