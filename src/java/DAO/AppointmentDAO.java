package DAO;

import Entity.Appointment;
import Entity.Patient;
import Entity.PolyClinic;
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
        String query = "INSERT INTO appointment (appointment_date, appointment_time, status, poly_clinic_id, patient_id, id, name) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            ps.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            ps.setString(3, appointment.getStatus());
            ps.setInt(4, appointment.getPolyClinic().getId()); // PolyClinic ID'si
            ps.setInt(5, appointment.getPatient().getId()); // Patient ID'si
            ps.setInt(6, appointment.getId());
            ps.setString(7, appointment.getName());
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
                // PolyClinic ve Patient nesnelerini almak için ilgili DAO kullanmanız gerekecek
                PolyClinicDAO polyClinicDAO = new PolyClinicDAO();
                PatientDAO patientDAO = new PatientDAO();

                PolyClinic polyClinic = polyClinicDAO.getPolyClinicById(rs.getInt("poly_clinic_id"));
                Patient patient = patientDAO.getPatientById(rs.getInt("patient_id"));

                Appointment appointment = new Appointment(
                    rs.getDate("appointment_date"),
                    rs.getTime("appointment_time").toLocalTime(),
                    rs.getString("status"),
                    polyClinic,
                    patient,
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
        String query = "UPDATE appointment SET appointment_date=?, appointment_time=?, status=?, poly_clinic_id=?, patient_id=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            ps.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            ps.setString(3, appointment.getStatus());
            ps.setInt(4, appointment.getPolyClinic().getId());
            ps.setInt(5, appointment.getPatient().getId());
            ps.setString(6, appointment.getName());
            ps.setInt(7, appointment.getId());
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
                    PolyClinicDAO polyClinicDAO = new PolyClinicDAO();
                    PatientDAO patientDAO = new PatientDAO();

                    PolyClinic polyClinic = polyClinicDAO.getPolyClinicById(rs.getInt("poly_clinic_id"));
                    Patient patient = patientDAO.getPatientById(rs.getInt("patient_id"));

                    appointment = new Appointment(
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time").toLocalTime(),
                        rs.getString("status"),
                        polyClinic,
                        patient,
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
