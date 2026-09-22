package com.agrotienda.tienda_agropecuaria.repository;

import com.agrotienda.tienda_agropecuaria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
