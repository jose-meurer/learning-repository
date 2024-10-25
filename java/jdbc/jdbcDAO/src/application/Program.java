package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.Instant;

public class Program {

    public static void main(String[] args) {

        Department obj = new Department(1, "books");

        Seller seller = new Seller(1, "José", "jose@gmail.com", Instant.now(), 4600.0, obj);

        System.out.println(seller);
    }
}
