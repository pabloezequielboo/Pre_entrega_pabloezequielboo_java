package Crudpoo;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorArticulos gestor = new GestorArticulos();
        int opcion;

        do {
            System.out.println("==== MENÚ CRUD DE ARTÍCULOS ====");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> gestor.crear();
                case 2 -> gestor.listar();
                case 3 -> gestor.modificar();
                case 4 -> gestor.eliminar();
            }
        } while (opcion != 0);
    }
}
