package DAO;

import Entity.Admin;
import java.sql.Connection;

public class AdminDAO extends BaseDAO<Admin> {

    public AdminDAO(Connection connection) {
        super(connection);
    }

    public AdminDAO() {
        
    }
    
    

}
