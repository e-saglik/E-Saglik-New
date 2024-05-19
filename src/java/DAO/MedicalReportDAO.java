package DAO;

import Entity.MedicalReport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalReportDAO extends BaseDAO<MedicalReport> {

    public MedicalReportDAO(Connection connection) {
        super(connection);
    }

    public MedicalReportDAO() {
    }

    public void createMedicalReport(MedicalReport medicalReport) {
        String query = "INSERT INTO medical_report (medical_report_date, diagnosis, description, id, name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(medicalReport.getMedicalReportDate().getTime()));
            ps.setString(2, medicalReport.getDiagnosis());
            ps.setString(3, medicalReport.getDescription());
            ps.setInt(4, medicalReport.getId());
            ps.setString(5, medicalReport.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MedicalReport> getMedicalReportList() {
        List<MedicalReport> medicalReportList = new ArrayList<>();
        String query = "SELECT * FROM medical_report ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                MedicalReport medicalReport = new MedicalReport(
                    rs.getDate("medical_report_date"),
                    rs.getString("diagnosis"),
                    rs.getString("description"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                medicalReportList.add(medicalReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalReportList;
    }

    public void updateMedicalReport(MedicalReport medicalReport) {
        String query = "UPDATE medical_report SET medical_report_date=?, diagnosis=?, description=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(medicalReport.getMedicalReportDate().getTime()));
            ps.setString(2, medicalReport.getDiagnosis());
            ps.setString(3, medicalReport.getDescription());
            ps.setString(4, medicalReport.getName());
            ps.setInt(5, medicalReport.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedicalReport(int id) {
        String query = "DELETE FROM medical_report WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MedicalReport getMedicalReportById(int id) {
        MedicalReport medicalReport = null;
        String query = "SELECT * FROM medical_report WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medicalReport = new MedicalReport(
                        rs.getDate("medical_report_date"),
                        rs.getString("diagnosis"),
                        rs.getString("description"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalReport;
    }
}
