package DAO;

import Entity.Hospital;
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
        String query = "SELECT * FROM hospital ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Hospital hospital = new Hospital(
                    rs.getString("location"),
                    rs.getString("capacity"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
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
        String query = "SELECT * FROM hospital WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hospital = new Hospital(
                        rs.getString("location"),
                        rs.getString("capacity"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospital;
    }
}
