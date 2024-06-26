package DAO;

import Entity.Disease;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entity.Patient;

public class DiseaseDAO extends BaseDAO<Disease> {

    private PatientDAO patientDAO;

    public DiseaseDAO(Connection connection) {
        super(connection);
    }

    public DiseaseDAO() {

    }

    public void CreateDisease(Disease disease) {
        String query = "INSERT INTO disease (description, id, name) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, disease.getDescription());
            ps.setInt(2, disease.getId());
            ps.setString(3, disease.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Disease> GetDiseaseList() {
        List<Disease> diseaseList = new ArrayList<>();
        String query = "SELECT * FROM disease ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement(); ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int patientId = rs.getInt("patient_id");
                Patient patient = patientDAO.getPatientById(patientId); // Mevcut getPatientById metodunuz kullanılıyor

                Disease disease = new Disease(
                        rs.getString("description"),
                        patient,
                        rs.getInt("id"),
                        rs.getString("name")
                );
                diseaseList.add(disease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseaseList;
    }

    public void UpdateDisease(Disease disease) {
        String query = "UPDATE disease SET description=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, disease.getDescription());
            ps.setString(2, disease.getName());
            ps.setInt(3, disease.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteDisease(int id) {
        String query = "DELETE FROM disease WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Disease GetDiseaseById(int id) {
        Disease disease = null;
        String query = "SELECT * FROM disease WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int patientId = rs.getInt("patient_id");
                    Patient patient = patientDAO.getPatientById(patientId); // Mevcut getPatientById metodunuz kullanılıyor

                    disease = new Disease(
                            rs.getString("description"),
                            patient,
                            rs.getInt("id"),
                            rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disease;
    }

}
