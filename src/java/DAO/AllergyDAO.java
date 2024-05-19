package DAO;

import Entity.Allergy;
import java.sql.Connection;



public class AllergyDAO extends BaseDAO<Allergy> {
    
    public AllergyDAO(Connection connection) {
        super(connection);
    }

    public AllergyDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
