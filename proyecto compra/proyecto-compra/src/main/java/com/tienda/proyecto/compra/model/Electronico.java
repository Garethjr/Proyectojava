package com.tienda.proyecto.compra.model;

public class Electronico extends Producto {
    private String marca;

    public Electronico(String nombre, double precioBase, String marca) {
        super(nombre, precioBase);
        this.marca = marca;
    }
}
