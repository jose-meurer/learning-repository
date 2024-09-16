package aula;

import aula.entities.Order;
import aula.enums.OrderStatus;

import java.time.*;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(2010, Instant.now(), OrderStatus.SHIPPED);
        System.out.println("Order 1: " + order);

        //Hora Local para Global
        Instant horaPedido = Instant.from(ZonedDateTime.ofLocal(LocalDateTime.parse("2024-09-10T15:34:31"), ZoneId.systemDefault(), ZoneOffset.UTC));
        Order order2 = new Order(3080, horaPedido, OrderStatus.valueOf("DELIVERED"));
        System.out.println("Order 2: " + order2);
    }
}