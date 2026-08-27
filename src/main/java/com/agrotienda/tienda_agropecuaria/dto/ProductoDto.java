package com.agrotienda.tienda_agropecuaria.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;
    private String categoria;
    private String tipoBovino;
    private int stock;
    private double precio;
}
