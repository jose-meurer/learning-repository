package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.Set;

public interface SellerDao {

    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(Integer id);

    Seller findById(Integer id);

    Set<Seller> findAll();

    Set<Seller> findByDepartment(Department department);
}
