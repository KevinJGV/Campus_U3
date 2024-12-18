public class acceso {

    // Instancia única de la clase (inicialización perezosa)
    private static acceso instancia;

    // Constructor privado para evitar instanciación externa
    private acceso() {
        // Inicialización de recursos si es necesario
    }

    // Método estático para obtener la instancia única
    public static acceso getInstancia() {
        if (instancia == null) {
            synchronized (acceso.class) {
                if (instancia == null) {
                    instancia = new acceso();
                }
            }
        }
        return instancia;
    }

    // Ejemplo de método que pertenece al Singleton
    public void mostrarMensaje(String mensaje) {
        System.out.println("Mensaje desde Singleton: " + mensaje);
    }
}

public class singleton {
    public static void main(String[] args) {
        // Obtener la instancia del Singleton
        acceso singleton1 = acceso.getInstancia();
        acceso singleton2 = acceso.getInstancia();

        // Usar un método del Singleton
        singleton1.mostrarMensaje("¡Hola, mundo!");

        // Verificar que ambas referencias apuntan a la misma instancia
        if (singleton1 == singleton2) {
            System.out.println("singleton1 y singleton2 son la misma instancia.");
        } else {
            System.out.println("singleton1 y singleton2 son instancias diferentes.");
        }
    }
}
