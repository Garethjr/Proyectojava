package com.tienda.proyecto.compra.model;

public class ClientePremium implements Cliente {
    private String nombre;

    public ClientePremium(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void realizarCompra(Vendible producto) {
        System.out.println("Cliente premium " + nombre + " ha comprado: " + producto.getClass().getSimpleName());
    }
}
