package predicate;

import predicate.entities.Product;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Set<Product> products  = new HashSet<>();

        products.add(new Product("Mouse", 400.0));
        products.add(new Product("Keyboard", 100.0));
        products.add(new Product("Microphone", 150.0));
        products.add(new Product("Cellphone", 950.0));

        //Maneiras de fazer a mesma coisa
//        products.removeIf(new MyPredicate());
//        products.removeIf(Product::staticPredicate);
//        products.removeIf(Product::predicate);
        products.removeIf(x -> x.getPrice() >= 410.00);

        products.forEach(System.out::println);
    }
}
