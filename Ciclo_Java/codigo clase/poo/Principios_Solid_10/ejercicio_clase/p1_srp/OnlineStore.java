package Principios_Solid_10.ejercicio_clase.p1_srp;

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

// Clase Pago
class Payment {
    public void pay(Order order) {
        //CalculatorOrder calcular = new CalculatorOrder();
        System.out.println("Paying " + CalculatorOrder.calculateTotal(order));
    }
}

public class OnlineStore {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 15.0);

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);

        Payment payment = new Payment();
        payment.pay(order);
    }
}