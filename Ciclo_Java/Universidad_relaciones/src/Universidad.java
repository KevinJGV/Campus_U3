import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private ArrayList<Persona> personal;
    private ArrayList<Actividad> actividades;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void addPersonal(Persona persona) {
        this.personal.add(persona);
    }

    public void addActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}