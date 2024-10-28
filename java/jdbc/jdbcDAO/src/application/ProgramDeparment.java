package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Set;

public class ProgramDeparment {

    public static void main(String[] args) {

        DepartmentDao departDao = DaoFactory.createrDepartmentDao();

        System.out.println("=== TEST 1: findById ===");
        Department dep = departDao.findById(4);
        System.out.println(dep);

        System.out.println();
        System.out.println("=== TEST 2: findAll ===");
        Set<Department> list = departDao.findAll();
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: insert ===");
        Department newDep = new Department(null, "House");
        departDao.insert(newDep);
        System.out.println("Inserted! New Department: " + newDep);

        System.out.println();
        System.out.println("=== TEST 4: update ===");
        dep = departDao.findById(6);
        dep.setName("Tables");
        departDao.update(dep);
        System.out.println("Update Completed");

        System.out.println();
        System.out.println("=== TEST 5: delete ===");
        departDao.deleteById(9);
        System.out.println("Delete completed");

        DB.closeConnection();
    }
}
