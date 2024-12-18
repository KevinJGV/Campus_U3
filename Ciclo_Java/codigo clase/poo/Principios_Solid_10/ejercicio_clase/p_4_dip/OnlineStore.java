package Principios_Solid_10.ejercicio_clase.p_4_dip;

import java.util.ArrayList;
import java.util.List;

// Clase Producto
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Clase Pedido
class Order {
    private List<Product> products;
    private double total;

    public Order() {

        products = new ArrayList<>();
        total = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

// Ejemplo de uso de una enumeración
enum Descuento {
    TARJETA(new PagoTarjeta(), 0.0),
    PAYPAL(new PagoPaypal(), 0.0),
    EFECTIVO(new PagoEfectivo(), 10.0), // 10% de descuento para efectivo{
    OTROMEDIO(new Payment(), 0); // Otro medio de pago asociado al pago Payment

    private final MetodoPago metodoDePago;
    private double descuento;

    Descuento(MetodoPago metodoDePago, double descuento) {
        this.metodoDePago = metodoDePago;
        this.descuento = descuento;
    }

    public MetodoPago getMetodoDePago() {
        return metodoDePago;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double MontoConDescuento(double monto) {
        return monto - (monto * descuento / 100);
    }
}

class CalculatorOrder {
    public static double calculateTotal(Order order) {
        double total = 0;
        for (Product product : order.getProducts()) {
            total += product.getPrice();
        }
        order.setTotal(total);

        return total;
    }
}

// Interfaz PaymentMethod
interface MetodoPago {
    void pay(Order order);
}

// Implementación de Tarjeta de Crédito
class PagoTarjeta implements MetodoPago {
    @Override
    public void pay(Order order) {
        Descuento descuento = Descuento.TARJETA;
        double valorPagar = descuento.MontoConDescuento(order.getTotal());
        System.out.println("Pago con Tarjeta de Credito: " + valorPagar);
    }
}

class PagoPaypal implements MetodoPago {
    @Override
    public void pay(Order order) {
        Descuento descuento = Descuento.PAYPAL;
        double valorPagar = descuento.MontoConDescuento(order.getTotal());
        System.out.println("Pago con PayPal: " + valorPagar);
    }
}

class PagoEfectivo implements MetodoPago {
    @Override
    public void pay(Order order) {
        Descuento descuento = Descuento.EFECTIVO;
        double valorPagar = descuento.MontoConDescuento(order.getTotal());
        System.out.println("Pago en efectivo: " + valorPagar);
    }
}

class Payment implements MetodoPago {
    @Override
    public void pay(Order order) {
        // Descuento descuento = Descuento.EFECTIVO;
        // double valorPagar = descuento.MontoConDescuento(order.getTotal());

        // No instancio un objeto de la enumeración. La uso como si fuera static
        double valorPagar = Descuento.OTROMEDIO.MontoConDescuento(order.getTotal());;
        System.out.println("Otro medio de pago " + valorPagar);
    }
}

class ProcesarOrder {
    public static void pagar(Order order, MetodoPago metodoPago) {
        if ((order != null) && (metodoPago != null)) {
            CalculatorOrder.calculateTotal(order);
            metodoPago.pay(order);

        } else if (metodoPago == null) {
            throw new IllegalArgumentException("Error. No se ha especificado el método de pago");

        } else {
            throw new IllegalArgumentException("Error. No se ha especificado la orden de pago");
        }

    }
}

public class OnlineStore {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 15.0);

        try {
            Order order = new Order();
            order.addProduct(product1);
            order.addProduct(product2);

            MetodoPago metodo = new PagoTarjeta();
            // metodo.pay(order);
            ProcesarOrder.pagar(order, metodo); // Pago con tarjeta
        } catch (IllegalArgumentException e) {
            System.out.println("Procesando y pagando el producto 1.\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Procesando y pagando el producto 1. \nError:" + e);
        }


        try {
            Order order2 = new Order();
            order2.addProduct(product1);
            order2.addProduct(product2);
            order2.addProduct(new Product("Product 3", 20.0));
            order2.addProduct(new Product("Product 4", 5.0));

            ProcesarOrder.pagar(order2, new PagoEfectivo()); // Pago en Efectivo
            ProcesarOrder.pagar(order2, new Payment()); // Pago con otro medio (Bitcoin :D)
        } catch (IllegalArgumentException e) {
            System.out.println("Procesando y pagando el producto 1.\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Procesando y pagando el producto 1. \nError:" + e);
        }

    }
}