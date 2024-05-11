package DAO;

import Entity.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO extends BaseDAO<Patient> {

    public PatientDAO(Connection connection) {
        super(connection);
    }

    

    
}
