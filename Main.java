import java.util.ArrayList;
import java.util.Scanner;

// Clase Productos
class Productos {
    // Atributos privados (abstracción + encapsulamiento)
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor vacío (polimorfismo)
    public Productos() {
    }

    // Constructor con parámetros (polimorfismo)
    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters (encapsulamiento)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // Método para imprimir datos del producto
    public void imprimir() {
        System.out.println("Producto: " + nombre +
                           " | Precio: $" + precio +
                           " | Cantidad: " + cantidad);
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Productos> listaProductos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Imprimir productos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Ingrese cantidad: ");
                    int cantidad = sc.nextInt();

                    // Crear producto con constructor parametrizado
                    Productos p = new Productos(nombre, precio, cantidad);
                    listaProductos.add(p);

                    System.out.println("Producto agregado con éxito.");
                    break;

                case 2:
                    System.out.println("\n--- Lista de productos ---");
                    if (listaProductos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Productos prod : listaProductos) {
                            prod.imprimir();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println(" Opción inválida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}
