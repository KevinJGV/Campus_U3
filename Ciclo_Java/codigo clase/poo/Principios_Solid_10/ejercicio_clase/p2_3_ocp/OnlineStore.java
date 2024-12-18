package Principios_Solid_10.ejercicio_clase.p2_3_ocp;

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

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

class CalculatorOrder {
    public static double calculateTotal(Order order) {
        double total = 0;
        for (Product product : order.getProducts()) {
            total += product.getPrice();
        }

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
        System.out.println("Pago con Tarjeta de Credito: " + CalculatorOrder.calculateTotal(order));
    }
}

class PagoPaypal implements MetodoPago {
    @Override
    public void pay(Order order) {
        System.out.println("Pago con PayPal: " + CalculatorOrder.calculateTotal(order));
    }
}

class PagoEfectivo implements MetodoPago {
    @Override
    public void pay(Order order) {
        System.out.println("Pago en efectivo: " + CalculatorOrder.calculateTotal(order));
    }
}

class Payment implements MetodoPago {
    @Override
    public void pay(Order order) {
        System.out.println("Pagando " + CalculatorOrder.calculateTotal(order));
    }
}

class ProcesarOrder {
    public void pagar(Order order, MetodoPago metodoPago) {
        metodoPago.pay(order);
    }
}

public class OnlineStore {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 15.0);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);


        MetodoPago metodo = new PagoTarjeta();
        metodo.pay(order);
    }
}