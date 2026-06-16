package com.microservice.course.appredisspringboot.service.impl;

import com.microservice.course.appredisspringboot.models.Producto;
import com.microservice.course.appredisspringboot.repository.ProductoRepository;
import com.microservice.course.appredisspringboot.service.IServiceProducto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceProductoIMPL implements IServiceProducto {

    private final ProductoRepository productoRepository;

    @Override
    @Cacheable(value = "productos", key = "#id")
    public Producto obtenerPorId(Long id) {
        log.info("LOG: Cache Miss! Buscando producto directamente en MYSQL....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    @CachePut(value = "productos", key = "#producto.id")
    public Producto actualizarProducto(Producto producto) {
        log.info("LOG: Cache Miss! Actualizando producto directamente en MYSQL y refrescando cache de redis....");
        return productoRepository.save(producto);
    }

    @Override
    @CacheEvict(value = "productos", key = "#id")
    public void eliminarProducto(Long id) {
        log.info("LOG: Eliminando producto de MySQL y purgando llave en Redis...");
        productoRepository.deleteById(id);
    }
}
