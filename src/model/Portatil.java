package model;

import visitor.Visitante;

/** Computadora portátil: precio 400 USD, peso 1000 g. */
public class Portatil implements Producto {

    private final String nombre;
    private final double precio;
    private final int pesoGramos;

    public Portatil(String nombre, double precio, int pesoGramos) {
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
