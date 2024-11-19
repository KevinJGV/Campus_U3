
package com.mycompany.olympusclub;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioEntrenador {
    private final List<Entrenador> entrenadores = new ArrayList<>();
    private int idActual = 1; // Para asignar IDs únicos

    public void registrarEntrenador(Scanner scanner) {
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la especialidad del entrenador: ");
        String especialidad = scanner.next();
        System.out.print("Ingrese los años de experiencia: ");
        int aniosExperiencia = scanner.nextInt();

        Entrenador entrenador = new Entrenador(idActual++, nombre, especialidad, aniosExperiencia);
        entrenadores.add(entrenador);
        System.out.println("Entrenador registrado exitosamente: " + entrenador);
    }

    public void modificarEntrenador(Scanner scanner) {
        System.out.print("Ingrese el ID del entrenador a modificar: ");
        int id = scanner.nextInt();
        Entrenador entrenador = buscarEntrenadorPorId(id);

        if (entrenador != null) {
            System.out.print("Ingrese el nuevo nombre (actual: " + entrenador.getNombre() + "): ");
            entrenador.setNombre(scanner.next());
            System.out.print("Ingrese la nueva especialidad (actual: " + entrenador.getEspecialidad() + "): ");
            entrenador.setEspecialidad(scanner.next());
            System.out.print("Ingrese los nuevos años de experiencia (actual: " + entrenador.getAniosExperiencia() + "): ");
            entrenador.setAniosExperiencia(scanner.nextInt());
            System.out.println("Entrenador modificado exitosamente: " + entrenador);
        } else {
            System.out.println("Entrenador con ID " + id + " no encontrado.");
        }
    }

    public void eliminarEntrenador(Scanner scanner) {
        System.out.print("Ingrese el ID del entrenador a eliminar: ");
        int id = scanner.nextInt();
        Entrenador entrenador = buscarEntrenadorPorId(id);

        if (entrenador != null) {
            entrenadores.remove(entrenador);
            System.out.println("Entrenador eliminado exitosamente.");
        } else {
            System.out.println("Entrenador con ID " + id + " no encontrado.");
        }
    }

    public void consultarEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            System.out.println("\n=== Lista de Entrenadores ===");
            for (Entrenador entrenador : entrenadores) {
                System.out.println(entrenador);
            }
        }
    }

    private Entrenador buscarEntrenadorPorId(int id) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId() == id) {
                return entrenador;
            }
        }
        return null;
    }
}

