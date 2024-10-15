package function;

import function.entities.Product;

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


        List<String> list = products.stream().map(prod -> prod.getName().toUpperCase()).toList();
        List<String> list1 = products.stream().map(new MyFunction()).toList();
        List<String> list2 = products.stream().map(Product::staticFunction).toList();
        List<String> list3 = products.stream().map(Product::function).toList();

        products.forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
