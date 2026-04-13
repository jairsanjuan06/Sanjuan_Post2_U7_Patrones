package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.domain.model.Producto;
import com.example.hexagonal.domain.port.in.ActualizarStockUseCase;
import com.example.hexagonal.domain.port.in.CrearProductoUseCase;
import com.example.hexagonal.domain.port.in.ListarProductosUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final CrearProductoUseCase crearUseCase;
    private final ListarProductosUseCase listarUseCase;
    private final ActualizarStockUseCase stockUseCase;

    public ProductoController(CrearProductoUseCase crearUseCase,
                              ListarProductosUseCase listarUseCase,
                              ActualizarStockUseCase stockUseCase) {
        this.crearUseCase = crearUseCase;
        this.listarUseCase = listarUseCase;
        this.stockUseCase = stockUseCase;
    }

    @GetMapping
    public List<Producto> listar() {
        return listarUseCase.listarTodos();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return listarUseCase.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return crearUseCase.crear(producto);
    }

    @PatchMapping("/{id}/stock")
    public Producto reducirStock(@PathVariable Long id, @RequestParam int cantidad) {
        return stockUseCase.reducirStock(id, cantidad);
    }
}
