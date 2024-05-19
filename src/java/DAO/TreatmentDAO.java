package DAO;

import Entity.Treatment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDAO extends BaseDAO<Treatment> {

    public TreatmentDAO(Connection connection) {
        super(connection);
    }

    public TreatmentDAO() {
    }

    public void createTreatment(Treatment treatment) {
        String query = "INSERT INTO treatment (startdate, end_date, description, id, name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(treatment.getStartdate().getTime()));
            ps.setDate(2, new java.sql.Date(treatment.getEndDate().getTime()));
            ps.setString(3, treatment.getDescription());
            ps.setInt(4, treatment.getId());
            ps.setString(5, treatment.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Treatment> getTreatmentList() {
        List<Treatment> treatmentList = new ArrayList<>();
        String query = "SELECT * FROM treatment ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Treatment treatment = new Treatment(
                    rs.getDate("startdate"),
                    rs.getDate("end_date"),
                    rs.getString("description"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                treatmentList.add(treatment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatmentList;
    }

    public void updateTreatment(Treatment treatment) {
        String query = "UPDATE treatment SET startdate=?, end_date=?, description=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(treatment.getStartdate().getTime()));
            ps.setDate(2, new java.sql.Date(treatment.getEndDate().getTime()));
            ps.setString(3, treatment.getDescription());
            ps.setString(4, treatment.getName());
            ps.setInt(5, treatment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTreatment(int id) {
        String query = "DELETE FROM treatment WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Treatment getTreatmentById(int id) {
        Treatment treatment = null;
        String query = "SELECT * FROM treatment WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    treatment = new Treatment(
                        rs.getDate("startdate"),
                        rs.getDate("end_date"),
                        rs.getString("description"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return treatment;
    }
}
