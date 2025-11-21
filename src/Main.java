import ecommerce.interfaces.Pagable;
import ecommerce.modelos.*;
import ecommerce.interfaces.Pago;
import ecommerce.interfaces.PagoConDescuento;
import ejercicios_excepciones.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TRABAJO PRÁCTICO 8 ===");
        System.out.println("Interfaces y Excepciones en Java");
        System.out.println("Alumno: Fabricio Puccio");
        System.out.println("=============================\n");

        // Parte 1: Sistema E-commerce
        ejecutarDemoEcommerce();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("PARTE 2: EJERCICIOS SOBRE EXCEPCIONES");
        System.out.println("=".repeat(60));

        // Parte 2: Ejercicios de Excepciones
        DivisionSegura.ejecutarEjercicio();
        ConversionCadenaNumero.ejecutarEjercicio();
        LecturaArchivo.ejecutarEjercicio();
        ValidacionEdad.ejecutarEjercicio();
        TryWithResourcesDemo.ejecutarEjercicio();

        System.out.println("\n¡TRABAJO PRÁCTICO COMPLETADO EXITOSAMENTE!");
        System.out.println("Todas las interfaces funcionando");
        System.out.println("Todas las excepciones manejadas correctamente");
        System.out.println("Sistema modular y robusto implementado");
    }

    private static void ejecutarDemoEcommerce() {
        System.out.println("DEMOSTRACIÓN SISTEMA E-COMMERCE");
        System.out.println("===================================\n");

        // 1. Crear cliente
        Cliente cliente = new Cliente("Fabricio Puccio", "fabricio@email.com");
        System.out.println("Cliente creado: " + cliente.getNombre());

        // 2. Crear productos
        Producto laptop = new Producto("Laptop Gamer", 1500000.00);
        Producto mouse = new Producto("Mouse Inalámbrico", 50000.00);
        Producto teclado = new Producto("Teclado Mecánico", 120000.00);

        System.out.println("\nProductos creados:");
        System.out.println("  - " + laptop);
        System.out.println("  - " + mouse);
        System.out.println("  - " + teclado);

        // 3. Crear pedido y agregar productos
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(laptop);
        pedido.agregarProducto(mouse);
        pedido.agregarProducto(teclado);

        System.out.println("\nPedido creado:");
        System.out.println("  " + pedido);

        // 4. Mostrar productos en el pedido
        System.out.println("\nProductos en el pedido:");
        for (Producto producto : pedido.getProductos()) {
            System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio());
        }

        // 5. Calcular total
        System.out.printf("\nTotal del pedido: $%.2f\n", pedido.calcularTotal());

        // 6. Procesar pagos con diferentes métodos
        System.out.println("\nPROCESANDO PAGOS:");
        System.out.println("-------------------");

        // Tarjeta de crédito con descuento
        TarjetaCredito tarjeta = new TarjetaCredito("1234-5678-9012-3456", "Fabricio Puccio", 2000000.00);
        double total = pedido.calcularTotal();

        System.out.println("\n--- Pago con Tarjeta de Crédito ---");
        double totalConDescuento = tarjeta.aplicarDescuento(total, 10.0); // 10% descuento
        boolean pagoExitosoTarjeta = tarjeta.procesarPago(totalConDescuento);

        if (pagoExitosoTarjeta) {
            pedido.cambiarEstado("PAGADO");
        }

        // PayPal
        PayPal paypal = new PayPal("fabricio.puccio@email.com", 1000000.00);

        System.out.println("\n--- Pago con PayPal ---");
        boolean pagoExitosoPayPal = paypal.procesarPago(50000.00); // Intentar pago de $50,000

        if (pagoExitosoPayPal) {
            System.out.println("Pago PayPal exitoso");
        }

        // 7. Cambiar estados del pedido (notificaciones)
        System.out.println("\nNOTIFICACIONES DE ESTADO:");
        System.out.println("---------------------------");
        pedido.cambiarEstado("EN PROCESO");
        pedido.cambiarEstado("ENVIADO");
        pedido.cambiarEstado("ENTREGADO");

        // 8. Demostrar polimorfismo con interfaces
        System.out.println("\nDEMOSTRACIÓN DE POLIMORFISMO:");
        System.out.println("-------------------------------");

        Pagable[] elementosPagables = {laptop, pedido};
        Pago[] metodosPago = {tarjeta, paypal};

        System.out.println("Elementos pagables:");
        for (Pagable pagable : elementosPagables) {
            System.out.println("  - " + pagable.getClass().getSimpleName() +
                    ": $" + pagable.calcularTotal());
        }

        System.out.println("Métodos de pago disponibles:");
        for (Pago pago : metodosPago) {
            System.out.println("  - " + pago.getClass().getSimpleName());
        }
    }
}