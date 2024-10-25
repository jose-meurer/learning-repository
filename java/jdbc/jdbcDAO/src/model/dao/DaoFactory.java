package model.dao;

import db.DB;
import model.dao.Impl.DepartmentDaoJdbc;
import model.dao.Impl.SellerDaoJdbc;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJdbc(DB.getConnection());
    }

    public static DepartmentDao createrDepartmentDao() {
        return new DepartmentDaoJdbc();
    }
}
