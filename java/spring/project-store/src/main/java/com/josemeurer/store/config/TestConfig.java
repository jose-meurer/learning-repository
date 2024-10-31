package com.josemeurer.store.config;

import com.josemeurer.store.entities.Order;
import com.josemeurer.store.entities.User;
import com.josemeurer.store.repositories.OrderRepository;
import com.josemeurer.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        //Users
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12345");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777888", "12345");

        userRepository.saveAll(Arrays.asList(u1, u2));


        //Orders
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
