package ecommerce.modelos;

import ecommerce.interfaces.Pagable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {
    private List<Producto> productos;
    private String estado;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularTotal();
        }
        return total;
    }

    public void cambiarEstado(String nuevoEstado) {
        String estadoAnterior = this.estado;
        this.estado = nuevoEstado;

        // Notificar al cliente del cambio de estado
        if (cliente != null) {
            String mensaje = "Tu pedido cambió de estado: " + estadoAnterior + " → " + nuevoEstado;
            cliente.notificar(mensaje);
        }
    }

    // Getters
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public String getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return String.format("Pedido [Cliente: %s, Estado: %s, Productos: %d, Total: $%.2f]",
                cliente.getNombre(), estado, productos.size(), calcularTotal());
    }
}