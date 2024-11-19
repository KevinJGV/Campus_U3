public class Main {
    String nombre;

    public Main(String n) {
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }
}

class PruebaMain {
    public static void main(String[] args) {
        Main menu = new Main("Sujeto X");

        System.out.println(menu.nombre);
    }
}