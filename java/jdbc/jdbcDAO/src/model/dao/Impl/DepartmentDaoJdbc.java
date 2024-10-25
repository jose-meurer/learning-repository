package model.dao.Impl;

import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Set;

public class DepartmentDaoJdbc implements DepartmentDao {

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public Set<Department> findAll() {
        return Set.of();
    }
}
