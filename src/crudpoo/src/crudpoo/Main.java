package crudpoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Articulo> articulos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt();
            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> actualizarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> buscarArticuloPorDescripcion();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== CRUD de Artículos (POO) ===");
        System.out.println("1) Crear artículo");
        System.out.println("2) Listar artículos");
        System.out.println("3) Modificar artículo");
        System.out.println("4) Eliminar artículo");
        System.out.println("5) Buscar por descripción");
        System.out.println("0) Salir");
        System.out.print("Opción: ");
    }

    private static int leerInt() {
        try {
            int v = Integer.parseInt(scanner.nextLine().trim());
            return v;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    private static void crearArticulo() {
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine().trim();
        System.out.print("Precio: ");
        double precio = leerDouble();
        if (Double.isNaN(precio)) {
            System.out.println("Precio inválido.");
            return;
        }
        Articulo a = new Articulo(descripcion, precio);
        articulos.add(a);
        System.out.println("Artículo creado: " + a);
    }

    private static void listarArticulos() {
        System.out.println("\n-- Listado de artículos --");
        if (articulos.isEmpty()) {
            System.out.println("(sin artículos)");
            return;
        }
        for (Articulo a : articulos) {
            System.out.println(a);
        }
    }

    private static Articulo buscarPorId(int id) {
        for (Articulo a : articulos) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    private static void actualizarArticulo() {
        System.out.print("Id del artículo a modificar: ");
        int id = leerInt();
        Articulo a = buscarPorId(id);
        if (a == null) {
            System.out.println("No existe el artículo con id " + id);
            return;
        }
        System.out.println("Artículo encontrado: " + a);
        System.out.print("Nueva descripción (vacío = sin cambios): ");
        String desc = scanner.nextLine().trim();
        if (!desc.isEmpty()) a.setDescripcion(desc);
        System.out.print("Nuevo precio (vacío = sin cambios): ");
        String precioStr = scanner.nextLine().trim();
        if (!precioStr.isEmpty()) {
            try {
                double p = Double.parseDouble(precioStr);
                a.setPrecio(p);
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. No se actualizó el precio.");
            }
        }
        System.out.println("Actualizado: " + a);
    }

    private static void eliminarArticulo() {
        System.out.print("Id del artículo a eliminar: ");
        int id = leerInt();
        boolean removed = articulos.removeIf(a -> a.getId() == id);
        if (removed) System.out.println("Artículo eliminado."); else System.out.println("No se encontró artículo con id " + id);
    }

    private static void buscarArticuloPorDescripcion() {
        System.out.print("Buscar descripción (texto): ");
        String q = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Articulo a : articulos) {
            if (a.getDescripcion() != null && a.getDescripcion().toLowerCase().contains(q)) {
                System.out.println(a);
                found = true;
            }
        }
        if (!found) System.out.println("No se encontraron artículos con esa descripción.");
    }

}