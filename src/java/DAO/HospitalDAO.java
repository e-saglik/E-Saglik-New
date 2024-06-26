package DAO;

import Entity.Doctor;
import Entity.Hospital;
import Entity.PolyClinic;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO extends BaseDAO<Hospital> {

    public HospitalDAO(Connection connection) {
        super(connection);
    }

    public HospitalDAO() {
    }

    public void createHospital(Hospital hospital) {
        String query = "INSERT INTO hospital (location, capacity, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, hospital.getLocation());
            ps.setString(2, hospital.getCapacity());
            ps.setInt(3, hospital.getId());
            ps.setString(4, hospital.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hospital> getHospitalList() {
        List<Hospital> hospitalList = new ArrayList<>();
        String query = "SELECT h.*, pc.id AS polyclinic_id, pc.name AS polyclinic_name, "
                + "d.id AS doctor_id, d.name AS doctor_name, d.specialization "
                + "FROM hospital h "
                + "LEFT JOIN polyclinic pc ON h.id = pc.hospital_id "
                + "LEFT JOIN doctor d ON h.id = d.hospital_id "
                + "ORDER BY h.id ASC";
        try (Statement st = this.GetConnection().createStatement(); ResultSet rs = st.executeQuery(query)) {
            int currentHospitalId = -1;
            Hospital hospital = null;
            List<PolyClinic> polyClinics = null;
            List<Doctor> doctors = null;
            while (rs.next()) {
                int hospitalId = rs.getInt("id");
                if (hospitalId != currentHospitalId) {
                    if (hospital != null) {
                        hospital.setPolyClinics(polyClinics);
                        hospital.setDoctors(doctors);
                        hospitalList.add(hospital);
                    }
                    currentHospitalId = hospitalId;
                    polyClinics = new ArrayList<>();
                    doctors = new ArrayList<>();
                    hospital = new Hospital(
                            rs.getString("location"),
                            rs.getString("capacity"),
                            polyClinics,
                            doctors,
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
                int polyclinicId = rs.getInt("polyclinic_id");
                if (polyclinicId != 0) {
                    polyClinics.add(new PolyClinic(polyclinicId, rs.getString("polyclinic_name")));
                }
                int doctorId = rs.getInt("doctor_id");
                if (doctorId != 0) {
                    doctors.add(new Doctor(doctorId, rs.getString("doctor_name"), rs.getString("specialization")));
                }
            }
            if (hospital != null) {
                hospital.setPolyClinics(polyClinics);
                hospital.setDoctors(doctors);
                hospitalList.add(hospital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalList;
    }

    public void updateHospital(Hospital hospital) {
        String query = "UPDATE hospital SET location=?, capacity=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, hospital.getLocation());
            ps.setString(2, hospital.getCapacity());
            ps.setString(3, hospital.getName());
            ps.setInt(4, hospital.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHospital(int id) {
        String query = "DELETE FROM hospital WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hospital getHospitalById(int id) {
        Hospital hospital = null;
        String query = "SELECT h.*, pc.id AS polyclinic_id, pc.name AS polyclinic_name, "
                + "d.id AS doctor_id, d.name AS doctor_name, d.specialization "
                + "FROM hospital h "
                + "LEFT JOIN polyclinic pc ON h.id = pc.hospital_id "
                + "LEFT JOIN doctor d ON h.id = d.hospital_id "
                + "WHERE h.id = ?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                List<PolyClinic> polyClinics = new ArrayList<>();
                List<Doctor> doctors = new ArrayList<>();
                while (rs.next()) {
                    if (hospital == null) {
                        hospital = new Hospital(
                                rs.getString("location"),
                                rs.getString("capacity"),
                                polyClinics,
                                doctors,
                                rs.getInt("id"),
                                rs.getString("name")
                        );
                    }
                    int polyclinicId = rs.getInt("polyclinic_id");
                    if (polyclinicId != 0) {
                        polyClinics.add(new PolyClinic(polyclinicId, rs.getString("polyclinic_name")));
                    }
                    int doctorId = rs.getInt("doctor_id");
                    if (doctorId != 0) {
                        doctors.add(new Doctor(doctorId, rs.getString("doctor_name"), rs.getString("specialization")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospital;
    }

}
