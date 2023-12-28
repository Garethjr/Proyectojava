package com.tienda.proyecto.compra.service;

import com.tienda.proyecto.compra.model.Cliente;
import com.tienda.proyecto.compra.model.Vendible;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private Cliente cliente;
    private List<Vendible> productos = new ArrayList<>();

    public CarritoCompra(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Vendible producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Vendible producto : productos) {
            total += producto.calcularPrecio();
        }
        return total;
    }
}
