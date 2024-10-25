package model.dao;

import model.entities.Department;

import java.util.Set;

public interface DepartmentDao {

    void insert(Department obj);

    void update(Department obj);

    void deleteById(Integer id);

    Department findById(Integer id);

    Set<Department> findAll();
}
