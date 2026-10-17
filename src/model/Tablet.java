package model;

import visitor.Visitante;

/** Tablet: precio 200 USD, peso 250 g. */
public class Tablet implements Producto {

    private final String nombre;
    private final double precio;
    private final int pesoGramos;

    public Tablet(String nombre, double precio, int pesoGramos) {
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
