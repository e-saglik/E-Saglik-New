package DAO;

import Entity.Insurance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceDAO extends BaseDAO<Insurance> {

    public InsuranceDAO(Connection connection) {
        super(connection);
    }

    public InsuranceDAO() {
    }

    public void createInsurance(Insurance insurance) {
        String query = "INSERT INTO insurance (provider, coverage_details, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, insurance.getProvider());
            ps.setString(2, insurance.getCoverageDetails());
            ps.setInt(3, insurance.getId());
            ps.setString(4, insurance.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Insurance> getInsuranceList() {
        List<Insurance> insuranceList = new ArrayList<>();
        String query = "SELECT * FROM insurance ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Insurance insurance = new Insurance(
                    rs.getString("provider"),
                    rs.getString("coverage_details"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                insuranceList.add(insurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insuranceList;
    }

    public void updateInsurance(Insurance insurance) {
        String query = "UPDATE insurance SET provider=?, coverage_details=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, insurance.getProvider());
            ps.setString(2, insurance.getCoverageDetails());
            ps.setString(3, insurance.getName());
            ps.setInt(4, insurance.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInsurance(int id) {
        String query = "DELETE FROM insurance WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Insurance getInsuranceById(int id) {
        Insurance insurance = null;
        String query = "SELECT * FROM insurance WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    insurance = new Insurance(
                        rs.getString("provider"),
                        rs.getString("coverage_details"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insurance;
    }
}
