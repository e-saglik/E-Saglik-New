package DAO;

import Entity.Allergy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllergyDAO extends BaseDAO<Allergy> {

    public AllergyDAO(Connection connection) {
        super(connection);
    }

    public AllergyDAO() {
    }

    public void createAllergy(Allergy allergy) {
        String query = "INSERT INTO allergy (type, severity, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, allergy.getType());
            ps.setInt(2, allergy.getSeverity());
            ps.setInt(3, allergy.getId());
            ps.setString(4, allergy.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Allergy> getAllergyList() {
        List<Allergy> allergyList = new ArrayList<>();
        String query = "SELECT * FROM allergy ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
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

    public void updateAllergy(Allergy allergy) {
        String query = "UPDATE allergy SET type=?, severity=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, allergy.getType());
            ps.setInt(2, allergy.getSeverity());
            ps.setString(3, allergy.getName());
            ps.setInt(4, allergy.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllergy(int id) {
        String query = "DELETE FROM allergy WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Allergy getAllergyById(int id) {
        Allergy allergy = null;
        String query = "SELECT * FROM allergy WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    allergy = new Allergy(rs.getString("type"), rs.getInt("severity"), rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allergy;
    }
}
