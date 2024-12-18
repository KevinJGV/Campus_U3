// Interfaz común para el objeto real y el proxy
interface Servicio {
    void realizarOperacion();
}

// Objeto real
class ServicioReal implements Servicio {
    @Override
    public void realizarOperacion() {
        System.out.println("Realizando operación en el Servicio Real.");
    }
}

// Proxy
class ServicioProxy implements Servicio {
    private ServicioReal servicioReal;
    private boolean accesoPermitido;

    public ServicioProxy(boolean accesoPermitido) {
        this.accesoPermitido = accesoPermitido;
    }

    @Override
    public void realizarOperacion() {
        if (accesoPermitido) {
            if (servicioReal == null) {
                servicioReal = new ServicioReal(); // Creación diferida (Lazy initialization)
            }
            System.out.println("Proxy: Acceso permitido. Delegando operación al Servicio Real.");
            servicioReal.realizarOperacion();
        } else {
            System.out.println("Proxy: Acceso denegado. No se puede realizar la operación.");
        }
    }
}

public class proxy {
    public static void main(String[] args) {
        // Crear un proxy con acceso permitido
        Servicio proxyConAcceso = new ServicioProxy(true);
        proxyConAcceso.realizarOperacion();

        System.out.println();

        // Crear un proxy con acceso denegado
        Servicio proxySinAcceso = new ServicioProxy(false);
        proxySinAcceso.realizarOperacion();
    }
}
