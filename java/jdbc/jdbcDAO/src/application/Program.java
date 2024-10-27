package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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


        DB.closeConnection();
    }
}
