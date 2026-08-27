package com.agrotienda.tienda_agropecuaria.repository;

import com.agrotienda.tienda_agropecuaria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Para la barra de busqueda de la tienda (ej: buscar "ivermectina")
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
