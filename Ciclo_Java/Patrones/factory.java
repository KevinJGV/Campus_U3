// Producto abstracto
interface Producto {
    void operacion();
}

// Producto concreto 1
class ProductoConcreto1 implements Producto {
    @Override
    public void operacion() {
        System.out.println("Operación del ProductoConcreto1");
    }
}   

// Producto concreto 2
class ProductoConcreto2 implements Producto {
    @Override
    public void operacion() {
        System.out.println("Operación del ProductoConcreto2");
    }
}

// Creador abstracto
abstract class Creador {
    public abstract Producto crearProducto(); // Factory Method
}

// Creador concreto 1
class CreadorConcreto1 extends Creador {
    @Override
    public Producto crearProducto() {
        return new ProductoConcreto1();
    }
}

// Creador concreto 2
class CreadorConcreto2 extends Creador {
    @Override
    public Producto crearProducto() {
        return new ProductoConcreto2();
    }
}

public class factory {
    public static void main(String[] args) {
        // Crear instancias de los creadores concretos
        Creador creador1 = new CreadorConcreto1();
        Creador creador2 = new CreadorConcreto2();

        // Usar el Factory Method para crear productos
        Producto producto1 = creador1.crearProducto();
        Producto producto2 = creador2.crearProducto();

        // Llamar a métodos en los productos creados
        producto1.operacion();
        producto2.operacion();
    }
}
