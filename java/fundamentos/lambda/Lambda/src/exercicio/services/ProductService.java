package exercicio.services;

import exercicio.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public Double filteredSum(List<Product> list, Predicate<Product> test) {
        double sum = 0.0;
        for(Product p : list) {
            if (test.test(p)) {
                sum += p.getPrice();
            }
        }

        return sum;
    }
}
