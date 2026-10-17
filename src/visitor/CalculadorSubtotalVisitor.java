package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Tablet;
import model.Television;

/** Acumula la suma de los precios de los productos visitados. */
public class CalculadorSubtotalVisitor implements Visitante {

    private double subtotal;

    @Override
    public void visitar(Tablet tablet) {
        subtotal += tablet.getPrecio();
    }

    @Override
    public void visitar(Portatil portatil) {
        subtotal += portatil.getPrecio();
    }

    @Override
    public void visitar(ComputadoraTorre computadoraTorre) {
        subtotal += computadoraTorre.getPrecio();
    }

    @Override
    public void visitar(Television television) {
        subtotal += television.getPrecio();
    }

    public double getSubtotal() {
        return subtotal;
    }
}
