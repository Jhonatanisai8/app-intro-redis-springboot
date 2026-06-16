package com.microservice.course.appredisspringboot.controllers;

import com.microservice.course.appredisspringboot.models.Producto;
import com.microservice.course.appredisspringboot.service.IServiceProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final IServiceProducto serviceProducto;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Producto> obtenerProductoPorId(Long id) {
        return ResponseEntity.ok(serviceProducto.obtenerPorId(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {
        producto.setId(id);
        return ResponseEntity.ok(serviceProducto.actualizarProducto(producto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        serviceProducto.eliminarProducto(id);
        return ResponseEntity.ok("Producto Eliminado con Éxito...");
    }

}
