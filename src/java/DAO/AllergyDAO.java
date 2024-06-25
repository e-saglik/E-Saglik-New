package DAO;

import Entity.Allergy;
import Entity.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllergyDAO extends BaseDAO<Allergy> {

    public AllergyDAO(Connection connection) {
        super(connection);
    }

    public AllergyDAO() {
        
    }

    
    

    public void CreateAllergy(Allergy allergy) {
        String query = "INSERT INTO allergy (type, severity, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, allergy.getType());
            ps.setInt(2, allergy.getSeverity());
            ps.setInt(3, allergy.getId());
            ps.setString(4, allergy.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Allergy> GetAllergyList() {
        List<Allergy> allergyList = new ArrayList<>();
        String query = "SELECT * FROM allergy ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Allergy allergy = new Allergy(rs.getString("type"), rs.getInt("severity"), rs.getInt("id"), rs.getString("name"));
                allergyList.add(allergy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allergyList;
    }

    public void UpdateAllergy(Allergy allergy) {
        String query = "UPDATE allergy SET type=?, severity=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, allergy.getType());
            ps.setInt(2, allergy.getSeverity());
            ps.setString(3, allergy.getName());
            ps.setInt(4, allergy.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteAllergy(int id) {
        String query = "DELETE FROM allergy WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public Allergy GetAllergyById(int id) {
    Allergy allergy = null;
    String query = "SELECT * FROM allergy WHERE id=?";
    try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Burada patientId'yi alıyoruz
                int patientId = rs.getInt("patient_id");

                // Patient nesnesini almak için bir yöntem çağırdığınızı varsayıyoruz
                Patient patient = getPatientById(patientId);

                // Allergy nesnesini yeni constructor kullanarak oluşturuyoruz
                allergy = new Allergy(rs.getString("type"), rs.getInt("severity"), patient, rs.getInt("id"), rs.getString("name"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return allergy;
}


}
