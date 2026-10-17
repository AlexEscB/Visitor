package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Tablet;
import model.Television;

/**
 * Acumula el costo de envío de los productos visitados.
 * Regla Wtech: por cada 100 g de peso el producto paga un 2% de envío
 * calculado sobre su precio.
 *   porcentajeEnvio = (pesoGramos / 100) * 2
 *   costoEnvio      = precio * porcentajeEnvio / 100
 */
public class CalculadorEnvioVisitor implements Visitante {

    private double costoEnvio;

    @Override
    public void visitar(Tablet tablet) {
        costoEnvio += calcular(tablet.getPrecio(), tablet.getPesoGramos());
    }

    @Override
    public void visitar(Portatil portatil) {
        costoEnvio += calcular(portatil.getPrecio(), portatil.getPesoGramos());
    }

    @Override
    public void visitar(ComputadoraTorre computadoraTorre) {
        costoEnvio += calcular(computadoraTorre.getPrecio(), computadoraTorre.getPesoGramos());
    }

    @Override
    public void visitar(Television television) {
        costoEnvio += calcular(television.getPrecio(), television.getPesoGramos());
    }

    private double calcular(double precio, int pesoGramos) {
        double porcentajeEnvio = (pesoGramos / 100.0) * 2.0;
        return precio * porcentajeEnvio / 100.0;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }
}
