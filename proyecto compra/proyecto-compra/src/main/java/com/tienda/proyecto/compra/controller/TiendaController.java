package com.tienda.proyecto.compra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    @GetMapping("/productos")
    public String mostrarProductos() {
        // Lógica para mostrar la lista de productos
        return "productos"; // Esto se traduce a la plantilla Thymeleaf 'productos.html'
    }

    @GetMapping("/carrito")
    public String verCarrito() {
        // Lógica para mostrar el contenido del carrito de compras
        return "carrito"; // Esto se traduce a la plantilla Thymeleaf 'carrito.html'
    }

    // Otros métodos para manejar diferentes acciones en la tienda
}
