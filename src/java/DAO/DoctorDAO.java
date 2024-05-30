package DAO;

import Entity.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO extends BaseDAO<Doctor> {

    public DoctorDAO(Connection connection) {
        super(connection);
    }

    public DoctorDAO() {
    }

    public void CreateDoctor(Doctor d) {
        String query = "INSERT INTO doctor (name, firstname, lastname, email, password, gender, phonenumber, address, specialization, hospital, prescription, appointment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, d.getName());
            ps.setString(2, d.getFirstName());
            ps.setString(3, d.getLastName());
            ps.setString(4, d.getEmail());
            ps.setString(5, d.getPassword());
            ps.setString(6, d.getGender());
            ps.setString(7, d.getPhoneNumber());
            ps.setString(8, d.getAddress());
            ps.setString(9, d.getSpecialization());
            ps.setString(10, d.getHospital());
            ps.setString(11, d.getPrescription());
            ps.setString(12, d.getAppointment());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> GetDoctorList(int page,int pageSize) {
        List<Doctor> doctorList = new ArrayList<>();
        int start =(page-1)*pageSize;
       String query = "SELECT * FROM doctor ORDER BY id ASC LIMIT " + pageSize + " OFFSET " + start;
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getString("specialization"), 
                        rs.getString("hospital"), rs.getString("prescription"), rs.getString("appointment"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phonenumber"), rs.getString("address"), rs.getInt("id"), rs.getString("name"));
                doctorList.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorList;
    }
    
    public int count() {
        int count=0;
        
        String query = "SELECT count(id) as doctor_count from doctor";
        try (
            Statement st = this.GetConnection().createStatement();
            ResultSet rs = st.executeQuery(query)) {
            rs.next();
            count= rs.getInt("doctor_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void UpdateDoctor(Doctor d) {
        String query = "UPDATE doctor SET name=?, firstname=?, lastname=?, email=?, password=?, gender=?, phonenumber=?, address=?, specialization=?, hospital=?, prescription=?, appointment=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, d.getName());
            ps.setString(2, d.getFirstName());
            ps.setString(3, d.getLastName());
            ps.setString(4, d.getEmail());
            ps.setString(5, d.getPassword());
            ps.setString(6, d.getGender());
            ps.setString(7, d.getPhoneNumber());
            ps.setString(8, d.getAddress());
            ps.setString(9, d.getSpecialization());
            ps.setString(10, d.getHospital());
            ps.setString(11, d.getPrescription());
            ps.setString(12, d.getAppointment());
            ps.setInt(13, d.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteDoctor(int id) {
        String query = "DELETE FROM doctor WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor GetDoctorById(int id) {
        Doctor doctor = null;
        String query = "SELECT * FROM doctor WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    doctor = new Doctor(rs.getString("specialization"), rs.getString("hospital"), rs.getString("prescription"), rs.getString("appointment"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phonenumber"), rs.getString("address"), rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

}
