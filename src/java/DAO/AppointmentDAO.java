package DAO;

import Entity.Appointment;
import java.sql.Connection;



public class AppointmentDAO extends BaseDAO<Appointment> {

    public AppointmentDAO(Connection connection) {
        super(connection);
    }

   
}
