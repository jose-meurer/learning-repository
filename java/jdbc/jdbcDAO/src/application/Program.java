package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.Instant;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departDao = DaoFactory.createrDepartmentDao();

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(168);
        System.out.println(seller);

        Department dep = departDao.findById(2);
        System.out.println(dep);

        System.out.println();
        System.out.println("=== TEST 2: findByDeparment ===");
        Set<Seller> list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: findAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Ana Pink", "ana@gmail.com",
                Instant.parse("2000-03-24T00:00:00Z"), 4200.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller: " + newSeller);


        DB.closeConnection();
    }
}
