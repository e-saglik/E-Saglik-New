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

    public void createDoctor(Doctor d) {
        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO doctor (name, firstname, lastname, email, password, gender, phonenumber, address, specialization, hospital, prescription, appointment) VALUES ('" + d.getName() + "','" + d.getFirstName() + "', '" + d.getLastName() + "', '" + d.getEmail() + "', '" + d.getPassword() + "', '" + d.getGender() + "', '" + d.getPhoneNumber() + "', '" + d.getAddress() + "', '" + d.getSpecialization() + "', '" + d.getHospital() + "', '" + d.getPrescription() + "', '" + d.getAppointment() + "')";
            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Doctor> getDoctorList() {

        List<Doctor> doctorList = new ArrayList<>();

        try {

            Statement st = this.getConnection().createStatement();

            String query = "select * from doctor order by id asc";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                doctorList.add(new Doctor(rs.getString("specialization"), rs.getString("hospital"), rs.getString("prescription"), rs.getString("appointment"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phonenumber"), rs.getString("address"), rs.getInt("id"), rs.getString("name")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorList;

    }

    public void updateDoctor(Doctor d) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "UPDATE doctor SET name='" + d.getName() + "', firstname='" + d.getFirstName() + "', lastname='" + d.getLastName() + "', email='" + d.getEmail() + "', password='" + d.getPassword() + "', gender='" + d.getGender() + "', phonenumber='" + d.getPhoneNumber() + "', address='" + d.getAddress() + "', specialization='" + d.getSpecialization() + "', hospital='" + d.getHospital() + "', prescription='" + d.getPrescription() + "', appointment='" + d.getAppointment() + "' WHERE id=" + d.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDoctor(int id) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM doctor WHERE id=" + id;
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Doctor getDoctorById(int id) {
        Doctor doctor = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM doctor WHERE id=" + id;
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                doctor = new Doctor(rs.getString("specialization"), rs.getString("hospital"), rs.getString("prescription"), rs.getString("appointment"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phonenumber"), rs.getString("address"), rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctor;
    }

}
