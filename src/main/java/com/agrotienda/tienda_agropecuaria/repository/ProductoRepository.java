package com.agrotienda.tienda_agropecuaria.repository;

import com.agrotienda.tienda_agropecuaria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Método de búsqueda derivado correcto por el atributo 'categoria'
    List<Producto> findByCategoriaId(Long categoriaId);
}
