package com.tienda.proyecto.compra.model;

public class ClienteRegular implements Cliente {
    private String nombre;

    public ClienteRegular(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void realizarCompra(Vendible producto) {
        System.out.println("Cliente regular " + nombre + " ha comprado: " + producto.getClass().getSimpleName());
    }
}
