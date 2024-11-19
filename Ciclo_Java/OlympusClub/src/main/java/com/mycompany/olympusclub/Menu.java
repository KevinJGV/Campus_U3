package com.mycompany.olympusclub;




import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        
        ServicioEntrenador servicioEntrenador = new ServicioEntrenador();
//        ServicioDeportista servicioDeportista = new ServicioDeportista();
//        ServicioEquipo servicioEquipo = new ServicioEquipo();
//        ServicioEntrenamiento servicioEntrenamiento = new ServicioEntrenamiento();

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestión de Entrenadores");
            System.out.println("2. Gestión de Deportistas");
            System.out.println("3. Gestión de Equipos");
            System.out.println("4. Gestión de Entrenamientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuEntrenadores(servicioEntrenador, scanner);
                    break;
//                case 2:
//                    menuDeportistas(servicioDeportista, scanner);
//                    break;
//                case 3:
//                    menuEquipos(servicioEquipo, scanner);
//                    break;
//                case 4:
//                    menuEntrenamientos(servicioEntrenamiento, scanner);
//                    break;
//                case 5:
//                    System.out.println("Saliendo del sistema...");
//                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void menuEntrenadores(ServicioEntrenador servicio, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Entrenadores ===");
            System.out.println("1. Registrar Entrenador");
            System.out.println("2. Modificar Entrenador");
            System.out.println("3. Eliminar Entrenador");
            System.out.println("4. Consultar Entrenadores");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    servicio.registrarEntrenador(scanner);
                    break;
                case 2:
                    servicio.modificarEntrenador(scanner);
                    break;
                case 3:
                    servicio.eliminarEntrenador(scanner);
                    break;
                case 4:
                    servicio.consultarEntrenadores();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

   
}

