package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.Instant;
import java.util.Set;

public class ProgramSeller {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Department dep = new Department(4, "Books");

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(168);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: findByDeparment ===");
        Set<Seller> list = sellerDao.findByDepartment(dep);
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: findAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 4: insert ===");
        Seller newSeller = new Seller(null, "Ana Pink", "ana@gmail.com",
                Instant.parse("2000-03-24T00:00:00Z"), 4200.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Seller: " + newSeller);

        System.out.println();
        System.out.println("=== TEST 5: update ===");
        seller = sellerDao.findById(166);
        seller.setName("Maria Green");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println();
        System.out.println("=== TEST 6: delete ===");
        sellerDao.deleteById(178);
        System.out.println("Delete completed");

        DB.closeConnection();
    }
}
