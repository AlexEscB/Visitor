package model;

import visitor.Visitante;

/**
 * Cualquier artículo que Wtech puede vender.
 * Solo declara que puede recibir un visitante (doble despacho).
 */
public interface Producto {
    void aceptar(Visitante visitante);
}
