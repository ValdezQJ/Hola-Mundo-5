import java.util.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static List<Producto> catalogo = new ArrayList<>();
    static Carrito carrito = new Carrito();

    public static void main(String[] args) {
        llenarCatalogo();

        int opcion;
        do {
            System.out.println("\n🛍️  SISTEMA DE COMPRAS EN CONSOLA");
            System.out.println("==================================");
            System.out.println("1. Ver catálogo de productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Eliminar producto del carrito");
            System.out.println("5. Finalizar compra");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> mostrarCatalogo();
                case 2 -> agregarAlCarrito();
                case 3 -> carrito.mostrarCarrito();
                case 4 -> eliminarDelCarrito();
                case 5 -> finalizarCompra();
                case 0 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("⚠️ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    static void llenarCatalogo() {
        catalogo.add(new Producto("P01", "Pan", 2));
        catalogo.add(new Producto("P02", "Leche", 4));
        catalogo.add(new Producto("P03", "Arroz", 5));
        catalogo.add(new Producto("P04", "Huevos", 6.5));
    }

    static void mostrarCatalogo() {
        System.out.println("\n📦 Catálogo de productos:");
        for (Producto p : catalogo) {
            System.out.println(p);
        }
    }

    static void agregarAlCarrito() {
        mostrarCatalogo();
        System.out.print("Ingrese el código del producto: ");
        String cod = sc.nextLine().trim();
        Producto producto = buscarProducto(cod);
        if (producto != null) {
            carrito.agregarProducto(producto);
            System.out.println("✅ Producto agregado al carrito.");
        } else {
            System.out.println("❌ Código inválido. Intente nuevamente.");
        }
    }

    static void eliminarDelCarrito() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        String cod = sc.nextLine().trim();
        carrito.eliminarProducto(cod);
        System.out.println("🗑️ Producto eliminado (si existía).");
    }

    static void finalizarCompra() {
        if (carrito.estaVacio()) {
            System.out.println("⚠️ No hay productos en el carrito.");
        } else {
            double total = carrito.calcularTotal();
            System.out.println("💰 Total a pagar: Bs. " + total);
            carrito.vaciarCarrito();
            System.out.println("🛒 Gracias por su compra.");
        }
    }

    static Producto buscarProducto(String codigo) {
        for (Producto p : catalogo) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
