package main;

import java.util.Locale;

import model.ComputadoraTorre;
import model.Pedido;
import model.Portatil;
import model.Tablet;
import model.Television;
import visitor.CalculadorEnvioVisitor;
import visitor.CalculadorSubtotalVisitor;

public class Main {

    public static void main(String[] args) {
        Pedido pedido = new Pedido()
                .agregar(new Tablet("Tablet", 200, 250), 2)
                .agregar(new Portatil("Computadora portátil", 400, 1000), 1)
                .agregar(new ComputadoraTorre("Computadora de torre", 600, 6000), 1)
                .agregar(new Television("Televisión", 300, 4000), 1);

        CalculadorSubtotalVisitor subtotalVisitor = new CalculadorSubtotalVisitor();
        pedido.aceptar(subtotalVisitor);
        double subtotal = subtotalVisitor.getSubtotal();

        CalculadorEnvioVisitor envioVisitor = new CalculadorEnvioVisitor();
        pedido.aceptar(envioVisitor);
        double costoEnvio = envioVisitor.getCostoEnvio();

        double total = subtotal + costoEnvio;

        System.out.printf(Locale.US, "Subtotal: $%.2f%n", subtotal);
        System.out.printf(Locale.US, "Envío:    $%.2f%n", costoEnvio);
        System.out.printf(Locale.US, "Total:    $%.2f%n", total);
    }
}
