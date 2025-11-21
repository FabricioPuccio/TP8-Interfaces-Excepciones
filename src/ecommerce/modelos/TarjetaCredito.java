package ecommerce.modelos;

import ecommerce.interfaces.PagoConDescuento;

public class TarjetaCredito implements PagoConDescuento {
    private String numeroTarjeta;
    private String titular;
    private double limite;

    public TarjetaCredito(String numeroTarjeta, String titular, double limite) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.limite = limite;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= limite) {
            System.out.println("Pago con Tarjeta de Crédito procesado: $" + monto);
            limite -= monto;
            return true;
        } else {
            System.out.println("Límite insuficiente en tarjeta. Límite: $" + limite);
            return false;
        }
    }

    @Override
    public double aplicarDescuento(double monto, double porcentajeDescuento) {
        double descuento = monto * (porcentajeDescuento / 100);
        double montoConDescuento = monto - descuento;
        System.out.println("Descuento aplicado: " + porcentajeDescuento + "% - Ahorro: $" + descuento);
        return montoConDescuento;
    }

    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public double getLimite() {
        return limite;
    }
}
