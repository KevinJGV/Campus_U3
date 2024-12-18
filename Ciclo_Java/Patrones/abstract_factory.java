// Productos abstractos
interface ProductoA {
    void operacionA();
}

interface ProductoB {
    void operacionB();
}

// Productos concretos para la familia 1
class ProductoA1 implements ProductoA {
    @Override
    public void operacionA() {
        System.out.println("Operación del ProductoA1");
    }
}

class ProductoB1 implements ProductoB {
    @Override
    public void operacionB() {
        System.out.println("Operación del ProductoB1");
    }
}

// Productos concretos para la familia 2
class ProductoA2 implements ProductoA {
    @Override
    public void operacionA() {
        System.out.println("Operación del ProductoA2");
    }
}

class ProductoB2 implements ProductoB {
    @Override
    public void operacionB() {
        System.out.println("Operación del ProductoB2");
    }
}

// Fábrica abstracta
interface FabricaAbstracta {
    ProductoA crearProductoA();
    ProductoB crearProductoB();
}

// Fábrica concreta 1
class FabricaConcreta1 implements FabricaAbstracta {
    @Override
    public ProductoA crearProductoA() {
        return new ProductoA1();
    }

    @Override
    public ProductoB crearProductoB() {
        return new ProductoB1();
    }
}

// Fábrica concreta 2
class FabricaConcreta2 implements FabricaAbstracta {
    @Override
    public ProductoA crearProductoA() {
        return new ProductoA2();
    }

    @Override
    public ProductoB crearProductoB() {
        return new ProductoB2();
    }
}

public class abstract_factory {
    public static void main(String[] args) {
        // Crear una fábrica concreta 1
        FabricaAbstracta fabrica1 = new FabricaConcreta1();
        ProductoA productoA1 = fabrica1.crearProductoA();
        ProductoB productoB1 = fabrica1.crearProductoB();

        // Usar los productos creados por la fábrica 1
        productoA1.operacionA();
        productoB1.operacionB();

        System.out.println();

        // Crear una fábrica concreta 2
        FabricaAbstracta fabrica2 = new FabricaConcreta2();
        ProductoA productoA2 = fabrica2.crearProductoA();
        ProductoB productoB2 = fabrica2.crearProductoB();

        // Usar los productos creados por la fábrica 2
        productoA2.operacionA();
        productoB2.operacionB();
    }
}
