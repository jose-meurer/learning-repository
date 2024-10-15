package function;

import function.entities.Product;

import java.util.function.Function;

public class MyFunction implements Function<Product, String> {

    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
