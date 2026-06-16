package com.microservice.course.appredisspringboot.service;

import com.microservice.course.appredisspringboot.models.Producto;

public interface IServiceProducto {
    Producto obtenerPorId(Long id);
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(Long id);
}
