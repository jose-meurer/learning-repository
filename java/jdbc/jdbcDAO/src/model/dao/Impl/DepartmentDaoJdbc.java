package model.dao.Impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class DepartmentDaoJdbc implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement state = null;
        try {
            String query = "INSERT INTO departments (Name) VALUES (?)";
            state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            state.setString(1, obj.getName());

            int rowsAffected = state.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = state.getGeneratedKeys();
                if (rs.next()) {
                    obj.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement state = null;
        try {
            String query = "UPDATE departments SET Name = ? WHERE departments.id = ?";
            state = conn.prepareStatement(query);
            state.setString(1, obj.getName());
            state.setInt(2, obj.getId());

            state.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement state = null;
        try {
            String query = "DELETE FROM departments WHERE Id = ?";
            state = conn.prepareStatement(query);
            state.setInt(1, id);

            int rowsAffected = state.executeUpdate();
            if (rowsAffected < 1) {
                throw new DbException("Id not found");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
        }
    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            String query = "SELECT p.* FROM departments p WHERE p.id = ?";
            state = conn.prepareStatement(query);
            state.setInt(1, id);

            rs = state.executeQuery();
            if (rs.next()) {
                Department dep = instantiationDepartment(rs);
                return dep;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiationDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("id"));
        dep.setName(rs.getString("name"));
        return dep;
    }

    @Override
    public Set<Department> findAll() {
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery("SELECT * FROM departments ORDER BY Name");

            Set<Department> list = new LinkedHashSet<>();
            while (rs.next()) {
                Department dep = instantiationDepartment(rs);
                list.add(dep);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeResultSet(rs);
        }
    }
}
