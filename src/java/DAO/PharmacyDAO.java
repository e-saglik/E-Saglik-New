package DAO;

import Entity.Pharmacy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacyDAO extends BaseDAO<Pharmacy> {

    public PharmacyDAO(Connection connection) {
        super(connection);
    }

    public PharmacyDAO() {
    }

    public void createPharmacy(Pharmacy pharmacy) {
        String query = "INSERT INTO pharmacy (location, id, name) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, pharmacy.getLocation());
            ps.setInt(2, pharmacy.getId());
            ps.setString(3, pharmacy.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pharmacy> getPharmacyList() {
        List<Pharmacy> pharmacyList = new ArrayList<>();
        String query = "SELECT * FROM pharmacy ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Pharmacy pharmacy = new Pharmacy(
                    rs.getString("location"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                pharmacyList.add(pharmacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pharmacyList;
    }

    public void updatePharmacy(Pharmacy pharmacy) {
        String query = "UPDATE pharmacy SET location=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, pharmacy.getLocation());
            ps.setString(2, pharmacy.getName());
            ps.setInt(3, pharmacy.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePharmacy(int id) {
        String query = "DELETE FROM pharmacy WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pharmacy getPharmacyById(int id) {
        Pharmacy pharmacy = null;
        String query = "SELECT * FROM pharmacy WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pharmacy = new Pharmacy(
                        rs.getString("location"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pharmacy;
    }
}
