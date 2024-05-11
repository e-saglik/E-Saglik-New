package DAO;

import Entity.Disease;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DiseaseDAO extends BaseDAO<Disease> {

    public DiseaseDAO(Connection connection) {
        super(connection);
    }

    
}
