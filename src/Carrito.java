import java.util.*;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equalsIgnoreCase(codigo));
    }

    public void mostrarCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        double total = 0;
        for (Producto p : productos) {
            System.out.println(p + " - Bs. " + p.getPrecio());
            total += p.getPrecio();
        }
        System.out.println("Total acumulado: Bs. " + total);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
