package DAO;

import Entity.Allergy;
import java.sql.Connection;



public class AllergyDAO extends BaseDAO<Allergy> {
    
    public AllergyDAO(Connection connection) {
        super(connection);
    }

    
}
