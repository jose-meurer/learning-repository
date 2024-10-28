package model.dao.Impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SellerDaoJdbc implements SellerDao {

    private Connection conn;

    public SellerDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement state = null;
        try {
            String query = "INSERT INTO sellers (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                    "VALUES (?, ?, ?, ?, ?)";
            state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            state.setString(1, obj.getName());
            state.setString(2, obj.getEmail());
            state.setTimestamp(3, Timestamp.from(obj.getBirthDate()));
            state.setDouble(4, obj.getBaseSalary());
            state.setInt(5, obj.getDepartment().getId());

            int rowsAffected = state.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = state.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement state = null;
        try {
            String query = "UPDATE sellers " +
                    "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
                    "WHERE Id = ?";
            state = conn.prepareStatement(query);

            state.setString(1, obj.getName());
            state.setString(2, obj.getEmail());
            state.setTimestamp(3, Timestamp.from(obj.getBirthDate()));
            state.setDouble(4, obj.getBaseSalary());
            state.setInt(5, obj.getDepartment().getId());
            state.setInt(6, obj.getId());

            state.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(state);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement state = null;
        try{
            String query = "DELETE FROM sellers WHERE Id = ?";
            state = conn.prepareStatement(query);
            state.setInt(1, id);

            int rowsAffected = state.executeUpdate();

            if(rowsAffected <= 0) {
                throw new DbException("Id not found!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(state);
        }
    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            String query = "SELECT sellers.*, departments.name depname " +
                    "FROM sellers INNER JOIN departments ON sellers.departmentid = departments.id " +
                    "WHERE sellers.id = ?";
            state = conn.prepareStatement(query);
            state.setInt(1, id);

            rs = state.executeQuery();
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs, dep);

                return seller;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("departmentId"));
        dep.setName(rs.getString("depName"));
        return dep;
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("id"));
        seller.setName(rs.getString("name"));
        seller.setEmail(rs.getString("email"));
        seller.setBaseSalary(rs.getDouble("baseSalary"));
        seller.setBirthDate(rs.getTimestamp("birthdate").toInstant());
        seller.setDepartment(dep);
        return seller;
    }

    @Override
    public Set<Seller> findAll() {
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            String query = "SELECT sellers.*, departments.Name as DepName " +
                    "FROM sellers INNER JOIN departments ON sellers.departmentId = departments.Id " +
                    "ORDER BY Name";
            rs = state.executeQuery(query);

            Set<Seller> list = new LinkedHashSet<>();
            Map<Integer, Department> map = new HashMap<>();
            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(dep.getId(), dep);
                }
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Set<Seller> findByDepartment(Department department) {
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            String query = "SELECT sellers.*, departments.name as DepName "
                    + "FROM sellers INNER JOIN departments ON sellers.departmentId = departments.id "
                    + "WHERE departments.id = ? "
                    + "ORDER BY name";
            state = conn.prepareStatement(query);
            state.setInt(1, department.getId());

            rs = state.executeQuery();

            Set<Seller> list = new LinkedHashSet<>();
            Map<Integer, Department> departments = new HashMap<>();
            while (rs.next()) {

                Department dep = departments.get(rs.getInt("departmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    departments.put(dep.getId(), dep);
                }
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
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
