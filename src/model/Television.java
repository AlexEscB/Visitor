package model;

import visitor.Visitante;

/** Televisión: precio 300 USD, peso 4000 g. */
public class Television implements Producto {

    private final String nombre;
    private final double precio;
    private final int pesoGramos;

    public Television(String nombre, double precio, int pesoGramos) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoGramos = pesoGramos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    @Override
    public void aceptar(Visitante visitante) {
        visitante.visitar(this);
    }
}
