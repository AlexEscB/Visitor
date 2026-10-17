package model;

import java.util.ArrayList;
import java.util.List;

import visitor.Visitante;

/**
 * Colección de productos con cantidades. No sabe calcular nada:
 * solo recorre sus elementos aplicando el visitante recibido.
 */
public class Pedido {

    private final List<Linea> lineas = new ArrayList<>();

    /** Agrega un producto con su cantidad. Rechaza cantidades <= 0. */
    public Pedido agregar(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        lineas.add(new Linea(producto, cantidad));
        return this;
    }

    /** Aplica el visitante a cada unidad de cada producto del pedido. */
    public void aceptar(Visitante visitante) {
        for (Linea linea : lineas) {
            for (int i = 0; i < linea.cantidad(); i++) {
                linea.producto().aceptar(visitante);
            }
        }
    }

    private record Linea(Producto producto, int cantidad) {
    }
}
