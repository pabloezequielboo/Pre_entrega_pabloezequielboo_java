package Crudpoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorArticulos implements Icrud{
    private ArrayList<Articulo> lista = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void crear() {
        try {
            System.out.print("Ingrese ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Validación de ID duplicado
            for (Articulo a : lista) {
                if (a.getId() == id) {
                    System.out.println("❌ Ya existe un artículo con ese ID.");
                    return;
                }
            }

            System.out.print("Ingrese descripción: ");
            String desc = sc.nextLine();
            while (desc.trim().isEmpty()) {
                System.out.print("Descripción vacía, vuelva a ingresar: ");
                desc = sc.nextLine();
            }

            System.out.print("Ingrese precio: ");
            double precio = sc.nextDouble();
            while (precio <= 0) {
                System.out.print("El precio debe ser mayor a 0: ");
                precio = sc.nextDouble();
            }

            Articulo nuevo = new Articulo(id, desc, precio);
            lista.add(nuevo);
            System.out.println("✅ Artículo agregado correctamente.\n");

        } catch (InputMismatchException e) {
            System.out.println("❌ Error: debe ingresar un número válido.");
            sc.nextLine(); // limpiar buffer
        }
    }

    @Override
    public void listar() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.\n");
        } else {
            System.out.println("=== LISTADO DE ARTÍCULOS ===");
            for (Articulo a : lista) {
                System.out.println(a.mostrarInformacion());
            }
            System.out.println();
        }
    }

    @Override
    public void modificar() {
        try {
            System.out.print("Ingrese ID del artículo a modificar: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Articulo a : lista) {
                if (a.getId() == id) {
                    System.out.print("Nueva descripción: ");
                    String desc = sc.nextLine();
                    if (!desc.trim().isEmpty()) {
                        a.setDescripcion(desc);
                    }

                    System.out.print("Nuevo precio: ");
                    double precio = sc.nextDouble();
                    if (precio > 0) {
                        a.setPrecio(precio);
                    }

                    System.out.println("✅ Artículo modificado con éxito.\n");
                    return;
                }
            }
            System.out.println("❌ Artículo no encontrado.\n");
        } catch (InputMismatchException e) {
            System.out.println("❌ Entrada inválida, intente nuevamente.");
            sc.nextLine();
        }
    }

    @Override
    public void eliminar() {
        try {
            System.out.print("Ingrese ID del artículo a eliminar: ");
            int id = sc.nextInt();

            for (Articulo a : lista) {
                if (a.getId() == id) {
                    lista.remove(a);
                    System.out.println("🗑️ Artículo eliminado correctamente.\n");
                    return;
                }
            }
            System.out.println("❌ Artículo no encontrado.\n");
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: debe ingresar un número válido.");
            sc.nextLine();
        }
    }

}
