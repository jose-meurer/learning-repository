package consumer;

import consumer.entities.Product;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Product> {

    @Override
    public void accept(Product product) {
       product.setPrice(product.getPrice() * 1.1);
    }
}
