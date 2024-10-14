package predicate;

import predicate.entities.Product;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product product) {
        return product.getPrice() >= 200.0;
    }
}
