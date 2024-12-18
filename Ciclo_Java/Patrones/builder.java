// Producto que se construirá
class Producto {
    private String parteA;
    private String parteB;
    private String parteC;

    // Métodos setter para las partes del producto
    public void setParteA(String parteA) {
        this.parteA = parteA;
    }

    public void setParteB(String parteB) {
        this.parteB = parteB;
    }

    public void setParteC(String parteC) {
        this.parteC = parteC;
    }

    @Override
    public String toString() {
        return "Producto [ParteA=" + parteA + ", ParteB=" + parteB + ", ParteC=" + parteC + "]";
    }
}

// Interfaz Builder
interface constructor {
    void construirParteA();
    void construirParteB();
    void construirParteC();
    Producto obtenerProducto();
}

// Builder concreto 1
class BuilderConcreto1 implements constructor {
    private Producto producto;

    public BuilderConcreto1() {
        this.producto = new Producto();
    }

    @Override
    public void construirParteA() {
        producto.setParteA("ParteA del BuilderConcreto1");
    }

    @Override
    public void construirParteB() {
        producto.setParteB("ParteB del BuilderConcreto1");
    }

    @Override
    public void construirParteC() {
        producto.setParteC("ParteC del BuilderConcreto1");
    }

    @Override
    public Producto obtenerProducto() {
        return producto;
    }
}

// Builder concreto 2
class BuilderConcreto2 implements constructor {
    private Producto producto;

    public BuilderConcreto2() {
        this.producto = new Producto();
    }

    @Override
    public void construirParteA() {
        producto.setParteA("ParteA del BuilderConcreto2");
    }

    @Override
    public void construirParteB() {
        producto.setParteB("ParteB del BuilderConcreto2");
    }

    @Override
    public void construirParteC() {
        producto.setParteC("ParteC del BuilderConcreto2");
    }

    @Override
    public Producto obtenerProducto() {
        return producto;
    }
}

// Director
class Director {
    private constructor builder;

    public void setBuilder(constructor builder) {
        this.builder = builder;
    }

    public Producto construirProducto() {
        builder.construirParteA();
        builder.construirParteB();
        builder.construirParteC();
        return builder.obtenerProducto();
    }
}

public class builder {
    public static void main(String[] args) {
        Director director = new Director();

        // Construir un producto usando BuilderConcreto1
        constructor builder1 = new BuilderConcreto1();
        director.setBuilder(builder1);
        Producto producto1 = director.construirProducto();
        System.out.println(producto1);

        // Construir un producto usando BuilderConcreto2
        constructor builder2 = new BuilderConcreto2();
        director.setBuilder(builder2);
        Producto producto2 = director.construirProducto();
        System.out.println(producto2);
    }
}
