package DAO;

import Entity.Medication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAO extends BaseDAO<Medication> {

    public MedicationDAO(Connection connection) {
        super(connection);
    }

    public MedicationDAO() {
    }

    public void createMedication(Medication medication) {
        String query = "INSERT INTO medication (dosage, id, name) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, medication.getDosage());
            ps.setInt(2, medication.getId());
            ps.setString(3, medication.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medication> getMedicationList() {
        List<Medication> medicationList = new ArrayList<>();
        String query = "SELECT * FROM medication ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Medication medication = new Medication(
                    rs.getString("dosage"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                medicationList.add(medication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicationList;
    }

    public void updateMedication(Medication medication) {
        String query = "UPDATE medication SET dosage=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, medication.getDosage());
            ps.setString(2, medication.getName());
            ps.setInt(3, medication.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedication(int id) {
        String query = "DELETE FROM medication WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medication getMedicationById(int id) {
        Medication medication = null;
        String query = "SELECT * FROM medication WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medication = new Medication(
                        rs.getString("dosage"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medication;
    }
}
