// Componente base
interface Componente {
    void operar();
}

// Hoja (Leaf)
class Hoja implements Componente {
    private String nombre;

    public Hoja(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void operar() {
        System.out.println("Hoja: " + nombre + " operando.");
    }
}

// Compuesto (Composite)
class Compuesto implements Componente {
    private String nombre;
    private final List<Componente> hijos = new ArrayList<>();

    public Compuesto(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Componente componente) {
        hijos.add(componente);
    }

    public void eliminar(Componente componente) {
        hijos.remove(componente);
    }

    @Override
    public void operar() {
        System.out.println("Compuesto: " + nombre + " operando con sus hijos:");
        for (Componente hijo : hijos) {
            hijo.operar();
        }
    }
}

public class composite {
    public static void main(String[] args) {
        // Crear hojas
        Componente hoja1 = new Hoja("Hoja 1");
        Componente hoja2 = new Hoja("Hoja 2");
        Componente hoja3 = new Hoja("Hoja 3");

        // Crear compuestos
        Compuesto compuesto1 = new Compuesto("Compuesto 1");
        Compuesto compuesto2 = new Compuesto("Compuesto 2");

        // Construir la jerarquía
        compuesto1.agregar(hoja1);
        compuesto1.agregar(hoja2);

        compuesto2.agregar(hoja3);
        compuesto2.agregar(compuesto1);

        // Operar con el compuesto más grande
        compuesto2.operar();
    }
}
