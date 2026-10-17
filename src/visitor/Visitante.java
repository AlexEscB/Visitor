package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Tablet;
import model.Television;

/**
 * Una operación de visita por cada tipo concreto de producto.
 * Las firmas permiten que cada visitante trabaje con el tipo exacto,
 * sin instanceof ni condicionales por tipo.
 */
public interface Visitante {
    void visitar(Tablet tablet);

    void visitar(Portatil portatil);

    void visitar(ComputadoraTorre computadoraTorre);

    void visitar(Television television);
}
