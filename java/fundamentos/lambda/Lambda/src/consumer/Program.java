package consumer;

import consumer.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 900.0));
        products.add(new Product("Mouse", 50.0));
        products.add(new Product("Tablet", 350.5));
        products.add(new Product("HD case", 79.8));

//        products.forEach(Product::staticConsumer);
//        products.forEach(Product::consumer);
        products.forEach(new MyConsumer());
        products.forEach(prod -> prod.setPrice(prod.getPrice() * 1.1));

        products.forEach(System.out::println);

    }
}
