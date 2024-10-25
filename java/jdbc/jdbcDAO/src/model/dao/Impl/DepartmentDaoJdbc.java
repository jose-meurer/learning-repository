package model.dao.Impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.Set;

public class DepartmentDaoJdbc implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJdbc(Connection conn) {
        this.conn = conn;
    }

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

        PreparedStatement state = null;
        ResultSet rs = null;
        try{
            String query = "SELECT p.* FROM departments p WHERE p.id = ?";
            state = conn.prepareStatement(query);
            state.setInt(1, id);

            rs = state.executeQuery();
            if(rs.next()) {
                Department dep = instantiationDepartment(rs);
                return dep;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(state);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiationDepartment(ResultSet rs) throws SQLException {
        Department dep =  new Department();
        dep.setId(rs.getInt("id"));
        dep.setName(rs.getString("name"));
        return dep;
    }

    @Override
    public Set<Department> findAll() {
        return Set.of();
    }
}
