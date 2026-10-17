package model;

import visitor.Visitante;

/** Computadora de torre: precio 600 USD, peso 6000 g. */
public class ComputadoraTorre implements Producto {

    private final String nombre;
    private final double precio;
    private final int pesoGramos;

    public ComputadoraTorre(String nombre, double precio, int pesoGramos) {
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
