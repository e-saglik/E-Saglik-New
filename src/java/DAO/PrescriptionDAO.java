package DAO;

import Entity.Prescription;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrescriptionDAO extends BaseDAO<Prescription> {

    public PrescriptionDAO(Connection connection) {
        super(connection);
    }

    public PrescriptionDAO() {
    }

    public void createPrescription(Prescription prescription) {
        String query = "INSERT INTO prescription (dosage, medication_list, instructions, id, name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, prescription.getDosage());
            ps.setString(2, convertListToString(prescription.getMedicationList()));
            ps.setString(3, prescription.getInstructions());
            ps.setInt(4, prescription.getId());
            ps.setString(5, prescription.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prescription> getPrescriptionList() {
        List<Prescription> prescriptionList = new ArrayList<>();
        String query = "SELECT * FROM prescription ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Prescription prescription = new Prescription(
                    rs.getString("dosage"),
                    convertStringToList(rs.getString("medication_list")),
                    rs.getString("instructions"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                prescriptionList.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptionList;
    }

    public void updatePrescription(Prescription prescription) {
        String query = "UPDATE prescription SET dosage=?, medication_list=?, instructions=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, prescription.getDosage());
            ps.setString(2, convertListToString(prescription.getMedicationList()));
            ps.setString(3, prescription.getInstructions());
            ps.setString(4, prescription.getName());
            ps.setInt(5, prescription.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePrescription(int id) {
        String query = "DELETE FROM prescription WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Prescription getPrescriptionById(int id) {
        Prescription prescription = null;
        String query = "SELECT * FROM prescription WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    prescription = new Prescription(
                        rs.getString("dosage"),
                        convertStringToList(rs.getString("medication_list")),
                        rs.getString("instructions"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescription;
    }

    private String convertListToString(List<Integer> list) {
        return list.toString().replace("[", "").replace("]", "").replace(" ", "");
    }

    private List<Integer> convertStringToList(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        String[] items = str.split(",");
        List<Integer> list = new ArrayList<>();
        for (String item : items) {
            list.add(Integer.parseInt(item));
        }
        return list;
    }
}
