package model.dao.Impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class SellerDaoJdbc implements SellerDao {

    private Connection conn;

    public SellerDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

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

                Department dep = new Department();
                dep.setId(rs.getInt("departmentid"));
                dep.setName(rs.getString("depname"));

                Seller seller = new Seller();
                seller.setId(rs.getInt("id"));
                seller.setName(rs.getString("name"));
                seller.setEmail(rs.getString("email"));
                seller.setBaseSalary(rs.getDouble("basesalary"));
                seller.setBirthDate(rs.getTimestamp("birthdate").toInstant());
                seller.setDepartment(dep);
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

    @Override
    public Set<Seller> findAll() {
        return Set.of();
    }
}
