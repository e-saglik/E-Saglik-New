package DAO;

import Entity.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO extends BaseDAO<Patient> {

    public PatientDAO(Connection connection) {
        super(connection);
    }

    public PatientDAO() {
    }

    public void createPatient(Patient p) {
        String patientQuery = "INSERT INTO patient (dateofbirth, bloodtype, appointment, insurance, vaccinationschedule, firstname, lastname, email, password, gender, phonenumber, address, name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(patientQuery, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new java.sql.Date(p.getDateOfBirth().getTime()));
            ps.setString(2, p.getBloodType());
            ps.setString(3, p.getAppointment());
            ps.setString(4, p.getInsurance());
            ps.setString(5, p.getVaccinationSchedule());
            ps.setString(6, p.getFirstName());
            ps.setString(7, p.getLastName());
            ps.setString(8, p.getEmail());
            ps.setString(9, p.getPassword());
            ps.setString(10, p.getGender());
            ps.setString(11, p.getPhoneNumber());
            ps.setString(12, p.getAddress());
            ps.setString(13, p.getName());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int patientId = generatedKeys.getInt(1);
                    insertPatientLists(patientId, p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertPatientLists(int patientId, Patient p) throws SQLException {
        insertList("Patient_Medication", "medicationId", patientId, p.getMedicationList());
        insertList("Patient_MedicalReport", "medicalReportId", patientId, p.getMedicalReportList());
        insertList("Patient_TestResult", "testResultId", patientId, p.getTestResultList());
        insertList("Patient_Disease", "diseaseId", patientId, p.getDiseaseList());
        insertList("Patient_Allergy", "allergyId", patientId, p.getAllergyList());
        insertStringList("Patient_Treatment", "treatment", patientId, p.getTreatmentList());
        insertStringList("Patient_Payment", "payment", patientId, p.getPaymentList());
        insertStringList("Patient_Notification", "notification", patientId, p.getNotificationList());
    }

    private void insertList(String tableName, String columnName, int patientId, List<Integer> list) throws SQLException {
        String query = "INSERT INTO " + tableName + " (patientId, " + columnName + ") VALUES (?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            for (Integer item : list) {
                ps.setInt(1, patientId);
                ps.setInt(2, item);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertStringList(String tableName, String columnName, int patientId, List<String> list) throws SQLException {
        String query = "INSERT INTO " + tableName + " (patientId, " + columnName + ") VALUES (?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            for (String item : list) {
                ps.setInt(1, patientId);
                ps.setString(2, item);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    public List<Patient> getPatientList() {
        List<Patient> patientList = new ArrayList<>();
        String query = "SELECT * FROM patient ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getDate("dateofbirth"),
                    rs.getString("bloodtype"),
                    rs.getString("appointment"),
                    getPatientList("Patient_Medication", "medicationId", rs.getInt("id")),
                    getPatientList("Patient_MedicalReport", "medicalReportId", rs.getInt("id")),
                    getPatientList("Patient_TestResult", "testResultId", rs.getInt("id")),
                    getPatientList("Patient_Disease", "diseaseId", rs.getInt("id")),
                    getPatientList("Patient_Allergy", "allergyId", rs.getInt("id")),
                    rs.getString("insurance"),
                    rs.getString("vaccinationschedule"),
                    getPatientStringList("Patient_Treatment", "treatment", rs.getInt("id")),
                    getPatientStringList("Patient_Payment", "payment", rs.getInt("id")),
                    getPatientStringList("Patient_Notification", "notification", rs.getInt("id")),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("gender"),
                    rs.getString("phonenumber"),
                    rs.getString("address"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                patientList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }

    private List<Integer> getPatientList(String tableName, String columnName, int patientId) throws SQLException {
        List<Integer> list = new ArrayList<>();
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE patientId=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getInt(columnName));
                }
            }
        }
        return list;
    }

    private List<String> getPatientStringList(String tableName, String columnName, int patientId) throws SQLException {
        List<String> list = new ArrayList<>();
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE patientId=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getString(columnName));
                }
            }
        }
        return list;
    }

    public void updatePatient(Patient p) {
        String query = "UPDATE patient SET dateofbirth=?, bloodtype=?, appointment=?, insurance=?, vaccinationschedule=?, firstname=?, lastname=?, email=?, password=?, gender=?, phonenumber=?, address=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(p.getDateOfBirth().getTime()));
            ps.setString(2, p.getBloodType());
            ps.setString(3, p.getAppointment());
            ps.setString(4, p.getInsurance());
            ps.setString(5, p.getVaccinationSchedule());
            ps.setString(6, p.getFirstName());
            ps.setString(7, p.getLastName());
            ps.setString(8, p.getEmail());
            ps.setString(9, p.getPassword());
            ps.setString(10, p.getGender());
            ps.setString(11, p.getPhoneNumber());
            ps.setString(12, p.getAddress());
            ps.setString(13, p.getName());
            ps.setInt(14, p.getId());
            ps.executeUpdate();

            deletePatientLists(p.getId());
            insertPatientLists(p.getId(), p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletePatientLists(int patientId) throws SQLException {
        deleteList("Patient_Medication", patientId);
        deleteList("Patient_MedicalReport", patientId);
        deleteList("Patient_TestResult", patientId);
        deleteList("Patient_Disease", patientId);
        deleteList("Patient_Allergy", patientId);
        deleteList("Patient_Treatment", patientId);
        deleteList("Patient_Payment", patientId);
        deleteList("Patient_Notification", patientId);
    }

    private void deleteList(String tableName, int patientId) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE patientId=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, patientId);
            ps.executeUpdate();
        }
    }

    public void deletePatient(int id) {
        String query = "DELETE FROM patient WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();

            deletePatientLists(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientById(int id) {
        Patient patient = null;
        String query = "SELECT * FROM patient WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    patient = new Patient(
                        rs.getDate("dateofbirth"),
                        rs.getString("bloodtype"),
                        rs.getString("appointment"),
                        getPatientList("Patient_Medication", "medicationId", rs.getInt("id")),
                        getPatientList("Patient_MedicalReport", "medicalReportId", rs.getInt("id")),
                        getPatientList("Patient_TestResult", "testResultId", rs.getInt("id")),
                        getPatientList("Patient_Disease", "diseaseId", rs.getInt("id")),
                        getPatientList("Patient_Allergy", "allergyId", rs.getInt("id")),
                        rs.getString("insurance"),
                        rs.getString("vaccinationschedule"),
                        getPatientStringList("Patient_Treatment", "treatment", rs.getInt("id")),
                        getPatientStringList("Patient_Payment", "payment", rs.getInt("id")),
                        getPatientStringList("Patient_Notification", "notification", rs.getInt("id")),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("gender"),
                        rs.getString("phonenumber"),
                        rs.getString("address"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
}
