package introduccion;

import java.lang.Thread.State;

public class DatosHilos_01 {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String nombre = Thread.currentThread().getName();
        int prioridad = Thread.currentThread().getPriority();
        State estado = Thread.currentThread().getState();
        String NomGrupo = Thread.currentThread().getThreadGroup().getName();

        System.out.println("\nid=" + id +
                "\nnombre= " + nombre +
                "\nprioridad= " + prioridad +
                "\nestado= " + estado +
                "\nnombre Grupo= " + NomGrupo);
    }
}
