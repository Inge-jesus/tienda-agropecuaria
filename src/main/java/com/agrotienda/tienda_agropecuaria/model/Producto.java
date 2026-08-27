package com.agrotienda.tienda_agropecuaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;       // Ej: Ivermectina, Melasa, Sal mineral
    private String categoria;    // Ej: Sanidad, Alimentacion
    private String tipoBovino;   // Ej: Vacas, Terneros, Toros
    private int stock;           // Cantidad disponible en bodega
    private double precio;
}