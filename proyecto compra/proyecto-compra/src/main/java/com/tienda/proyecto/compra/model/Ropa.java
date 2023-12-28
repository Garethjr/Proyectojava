package com.tienda.proyecto.compra.model;

public class Ropa extends Producto {
    private String talla;

    public Ropa(String nombre, double precioBase, String talla) {
        super(nombre, precioBase);
        this.talla = talla;
    }
}
