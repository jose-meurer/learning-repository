package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(168);
        System.out.println(seller);

        DepartmentDao departDao = DaoFactory.createrDepartmentDao();
        Department dep = departDao.findById(2);
        System.out.println(dep);

        DB.closeConnection();
    }
}
