package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Producto;
import com.uptc.frw.casoestudio.service.ProductoService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final OperacionService operacionService;

    @Autowired
    public ProductoController(ProductoService productoService, OperacionService operacionService) {
        this.productoService = productoService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<Producto> obtenerProductos() {
        operacionService.registrarLog("producto", "get", "Consulta todos los productos");
        return productoService.findAll();
    }


    @GetMapping("{id}")
    public Producto obtenerProductoPorId(@PathVariable long id) {
        operacionService.registrarLog("producto", "get", "Consulta el producto por id: " + id);
        return (Producto) productoService.findAll();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        operacionService.registrarLog("producto", "post", "Crear el producto: " + producto);
        return productoService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProductoPorId(@PathVariable long id) {
        operacionService.registrarLog("producto", "delete", "Elimina el producto por id: " + id);
        productoService.delete(id);
    }

    @PutMapping
    public Producto modificarProducto(@RequestParam long id, @RequestBody Producto producto) {
        operacionService.registrarLog("producto", "put", "Modifica el producto por id: " + id);
        return productoService.update(id, producto);
    }
}
