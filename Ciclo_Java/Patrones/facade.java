// Subsystem 1
class SubSistema1 {
    public void operacion1() {
        System.out.println("SubSistema1: Realizando operación 1");
    }
}

// Subsystem 2
class SubSistema2 {
    public void operacion2() {
        System.out.println("SubSistema2: Realizando operación 2");
    }
}

// Subsystem 3
class SubSistema3 {
    public void operacion3() {
        System.out.println("SubSistema3: Realizando operación 3");
    }
}

// Facade
class Fachada {
    private SubSistema1 subsistema1;
    private SubSistema2 subsistema2;
    private SubSistema3 subsistema3;

    public Fachada() {
        this.subsistema1 = new SubSistema1();
        this.subsistema2 = new SubSistema2();
        this.subsistema3 = new SubSistema3();
    }

    public void operacionCompleta() {
        System.out.println("Fachada: Coordinando operaciones en subsistemas:");
        subsistema1.operacion1();
        subsistema2.operacion2();
        subsistema3.operacion3();
    }

    public void operacionParcial() {
        System.out.println("Fachada: Coordinando operaciones parciales:");
        subsistema1.operacion1();
        subsistema2.operacion2();
    }
}

public class facade {
    public static void main(String[] args) {
        // Usar la fachada para acceder a las operaciones de los subsistemas
        Fachada fachada = new Fachada();
        
        // Realizar una operación completa a través de la fachada
        fachada.operacionCompleta();
        
        System.out.println();

        // Realizar una operación parcial a través de la fachada
        fachada.operacionParcial();
    }
}
