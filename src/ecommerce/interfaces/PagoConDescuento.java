package ecommerce.interfaces;

public interface PagoConDescuento extends Pago {
    double aplicarDescuento(double monto, double porcentajeDescuento);
}
