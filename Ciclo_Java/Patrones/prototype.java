// Interfaz Prototype
interface Prototipo extends Cloneable {
    Prototipo clonar(); // Método para clonar el objeto
}

// Clase concreta que implementa Prototype
class PrototipoConcreto implements Prototipo {
    private String estado;

    public PrototipoConcreto(String estado) {
        this.estado = estado;
    }

    // Getter y Setter
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Implementación del método clonar
    @Override
    public Prototipo clonar() {
        try {
            return (Prototipo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el objeto", e);
        }
    }

    @Override
    public String toString() {
        return "PrototipoConcreto [estado=" + estado + "]";
    }
}

public class prototype {
    public static void main(String[] args) {
        // Crear una instancia del prototipo
        PrototipoConcreto prototipoOriginal = new PrototipoConcreto("Estado inicial");

        // Clonar el prototipo
        PrototipoConcreto prototipoClonado = (PrototipoConcreto) prototipoOriginal.clonar();

        // Modificar el estado del clon
        prototipoClonado.setEstado("Estado modificado");

        // Mostrar los objetos originales y clonados
        System.out.println("Prototipo original: " + prototipoOriginal);
        System.out.println("Prototipo clonado: " + prototipoClonado);
    }
}
