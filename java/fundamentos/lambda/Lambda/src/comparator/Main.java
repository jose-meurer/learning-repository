package comparator;

import comparator.entities.Product;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Tv", 1200.0));
        products.add(new Product("Mouse", 400.0));
        products.add(new Product("Keyboard", 200.0));
        products.add(new Product("Microphone", 150.0));
        products.add(new Product("Cellphone", 950.0));

        //Classe anonima
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        };

        //Entendi melhor quando estudei javascript
        Comparator<Product> comp2 = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        //Arrow function
        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        products.forEach(System.out::println);

    }
}