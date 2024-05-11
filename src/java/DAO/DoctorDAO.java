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

            String query = "select * from doctor";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                doctorList.add(new Doctor(rs.getString("specialization"), rs.getString("hospital"), rs.getString("prescription"), rs.getString("appointment"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phonenumber"), rs.getString("address"), rs.getInt("id"), rs.getString("name")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return doctorList;

    }

}
