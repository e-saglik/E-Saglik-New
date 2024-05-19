package DAO;

import Entity.Vaccine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccineDAO extends BaseDAO<Vaccine> {

    public VaccineDAO(Connection connection) {
        super(connection);
    }

    public VaccineDAO() {
    }

    public void createVaccine(Vaccine vaccine) {
        String query = "INSERT INTO vaccine (type, id, name) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, vaccine.getType());
            ps.setInt(2, vaccine.getId());
            ps.setString(3, vaccine.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vaccine> getVaccineList() {
        List<Vaccine> vaccineList = new ArrayList<>();
        String query = "SELECT * FROM vaccine ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Vaccine vaccine = new Vaccine(
                    rs.getString("type"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                vaccineList.add(vaccine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccineList;
    }

    public void updateVaccine(Vaccine vaccine) {
        String query = "UPDATE vaccine SET type=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, vaccine.getType());
            ps.setString(2, vaccine.getName());
            ps.setInt(3, vaccine.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVaccine(int id) {
        String query = "DELETE FROM vaccine WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vaccine getVaccineById(int id) {
        Vaccine vaccine = null;
        String query = "SELECT * FROM vaccine WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    vaccine = new Vaccine(
                        rs.getString("type"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccine;
    }
}
