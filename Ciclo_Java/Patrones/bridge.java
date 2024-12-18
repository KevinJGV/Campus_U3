// Implementador (Implementor)
interface Implementador {
    void operacionImplementacion();
}

// Implementador concreto 1
class ImplementadorConcreto1 implements Implementador {
    @Override
    public void operacionImplementacion() {
        System.out.println("Operación implementada por ImplementadorConcreto1");
    }
}

// Implementador concreto 2
class ImplementadorConcreto2 implements Implementador {
    @Override
    public void operacionImplementacion() {
        System.out.println("Operación implementada por ImplementadorConcreto2");
    }
}

// Abstracción
abstract class Abstraccion {
    protected Implementador implementador;

    public Abstraccion(Implementador implementador) {
        this.implementador = implementador;
    }

    public abstract void operacion();
}

// Abstracción refinada
class AbstraccionRefinada extends Abstraccion {
    public AbstraccionRefinada(Implementador implementador) {
        super(implementador);
    }

    @Override
    public void operacion() {
        System.out.println("Abstracción refinada delegando a la implementación:");
        implementador.operacionImplementacion();
    }
}

public class bridge {
    public static void main(String[] args) {
        // Usar ImplementadorConcreto1 con la abstracción refinada
        Implementador implementador1 = new ImplementadorConcreto1();
        Abstraccion abstraccion1 = new AbstraccionRefinada(implementador1);
        abstraccion1.operacion();

        System.out.println();

        // Usar ImplementadorConcreto2 con la abstracción refinada
        Implementador implementador2 = new ImplementadorConcreto2();
        Abstraccion abstraccion2 = new AbstraccionRefinada(implementador2);
        abstraccion2.operacion();
    }
}
