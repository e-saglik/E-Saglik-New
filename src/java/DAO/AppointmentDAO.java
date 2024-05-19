package DAO;

import Entity.Appointment;
import java.sql.Connection;



public class AppointmentDAO extends BaseDAO<Appointment> {

    public AppointmentDAO(Connection connection) {
        super(connection);
    }

    public AppointmentDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
