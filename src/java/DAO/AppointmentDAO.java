package DAO;

import Entity.Appointment;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO extends BaseDAO<Appointment> {

    public AppointmentDAO(Connection connection) {
        super(connection);
    }

    public AppointmentDAO() {
        
    }

   
    

    public void CreateAppointment(Appointment appointment) {
        String query = "INSERT INTO appointment (appointment_date, appointment_time, status, id, name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            ps.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            ps.setString(3, appointment.getStatus());
            ps.setInt(4, appointment.getId());
            ps.setString(5, appointment.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> GetAppointmentList() {
        List<Appointment> appointmentList = new ArrayList<>();
        String query = "SELECT * FROM appointment ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getDate("appointment_date"),
                    rs.getTime("appointment_time").toLocalTime(),
                    rs.getString("status"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                appointmentList.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    public void UpdateAppointment(Appointment appointment) {
        String query = "UPDATE appointment SET appointment_date=?, appointment_time=?, status=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            ps.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            ps.setString(3, appointment.getStatus());
            ps.setString(4, appointment.getName());
            ps.setInt(5, appointment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteAppointment(int id) {
        String query = "DELETE FROM appointment WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Appointment GetAppointmentById(int id) {
        Appointment appointment = null;
        String query = "SELECT * FROM appointment WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    appointment = new Appointment(
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time").toLocalTime(),
                        rs.getString("status"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }
}
