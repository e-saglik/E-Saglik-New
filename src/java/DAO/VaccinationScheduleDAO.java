package DAO;

import Entity.VaccinationSchedule;
import Entity.Vaccine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccinationScheduleDAO extends BaseDAO<VaccinationSchedule> {

    public VaccinationScheduleDAO(Connection connection) {
        super(connection);
    }

    public VaccinationScheduleDAO() {
    }

    public void createVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        String query = "INSERT INTO vaccination_schedule (vaccine_type, due_date, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, vaccinationSchedule.getVaccineName().getType());
            ps.setDate(2, new java.sql.Date(vaccinationSchedule.getDueDate().getTime()));
            ps.setInt(3, vaccinationSchedule.getId());
            ps.setString(4, vaccinationSchedule.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<VaccinationSchedule> getVaccinationScheduleList() {
        List<VaccinationSchedule> vaccinationScheduleList = new ArrayList<>();
        String query = "SELECT * FROM vaccination_schedule ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Vaccine vaccine = new Vaccine(rs.getString("vaccine_type"), rs.getInt("id"), rs.getString("name"));
                VaccinationSchedule vaccinationSchedule = new VaccinationSchedule(
                    vaccine,
                    rs.getDate("due_date"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                vaccinationScheduleList.add(vaccinationSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccinationScheduleList;
    }

    public void updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        String query = "UPDATE vaccination_schedule SET vaccine_type=?, due_date=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, vaccinationSchedule.getVaccineName().getType());
            ps.setDate(2, new java.sql.Date(vaccinationSchedule.getDueDate().getTime()));
            ps.setString(3, vaccinationSchedule.getName());
            ps.setInt(4, vaccinationSchedule.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVaccinationSchedule(int id) {
        String query = "DELETE FROM vaccination_schedule WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public VaccinationSchedule getVaccinationScheduleById(int id) {
        VaccinationSchedule vaccinationSchedule = null;
        String query = "SELECT * FROM vaccination_schedule WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Vaccine vaccine = new Vaccine(rs.getString("vaccine_type"), rs.getInt("id"), rs.getString("name"));
                    vaccinationSchedule = new VaccinationSchedule(
                        vaccine,
                        rs.getDate("due_date"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaccinationSchedule;
    }
}
