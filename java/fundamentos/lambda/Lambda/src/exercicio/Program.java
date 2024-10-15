package exercicio;

import exercicio.entities.Product;
import exercicio.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.5));
        list.add(new Product("HD case", 79.8));

        ProductService service = new ProductService();
        System.out.println(service.filteredSum(list, prod -> prod.getPrice() <= 100.0));
    }
}
