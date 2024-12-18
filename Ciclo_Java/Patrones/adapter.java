// Interfaz objetivo (Target)
interface Objetivo {
    void operacion();
}

// Clase adaptada (Adaptada)
class Adaptada {
    public void operacionEspecifica() {
        System.out.println("Operación específica de la clase Adaptada");
    }
}

// Clase adaptadora (Adapter)
class Adaptador implements Objetivo {
    private final Adaptada adaptada;

    public Adaptador(Adaptada adaptada) {
        this.adaptada = adaptada;
    }

    @Override
    public void operacion() {
        // Adaptar la operación específica al formato esperado por la interfaz objetivo
        adaptada.operacionEspecifica();
    }
}

public class adapter {
    public static void main(String[] args) {
        // Crear una instancia de la clase Adaptada
        Adaptada adaptada = new Adaptada();

        // Usar el Adaptador para que se comporte como el Objetivo
        Objetivo adaptador = new Adaptador(adaptada);

        // Llamar al método esperado por la interfaz Objetivo
        adaptador.operacion();
    }
}
