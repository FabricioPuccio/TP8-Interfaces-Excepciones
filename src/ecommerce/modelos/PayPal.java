package ecommerce.modelos;

import ecommerce.interfaces.Pago;

public class PayPal implements Pago {
    private String email;
    private double saldo;

    public PayPal(String email, double saldo) {
        this.email = email;
        this.saldo = saldo;
    }

    @Override
    public boolean procesarPago(double monto) {
        if (monto <= saldo) {
            System.out.println("Pago con PayPal procesado: $" + monto + " - Email: " + email);
            saldo -= monto;
            return true;
        } else {
            System.out.println("Saldo insuficiente en PayPal. Saldo: $" + saldo);
            return false;
        }
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }
}
