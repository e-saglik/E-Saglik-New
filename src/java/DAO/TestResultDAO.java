package DAO;

import Entity.TestResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestResultDAO extends BaseDAO<TestResult> {

    public TestResultDAO(Connection connection) {
        super(connection);
    }

    public TestResultDAO() {
    }

    public void createTestResult(TestResult testResult) {
        String query = "INSERT INTO test_result (date, test_type, test_name, test_normal_value, test_value, id, name) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(testResult.getDate().getTime()));
            ps.setString(2, testResult.getTestType());
            ps.setString(3, testResult.getTestName());
            ps.setString(4, testResult.getTestNormalValue());
            ps.setString(5, testResult.getTestValue());
            ps.setInt(6, testResult.getId());
            ps.setString(7, testResult.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TestResult> getTestResultList() {
        List<TestResult> testResultList = new ArrayList<>();
        String query = "SELECT * FROM test_result ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                TestResult testResult = new TestResult(
                    rs.getDate("date"),
                    rs.getString("test_type"),
                    rs.getString("test_name"),
                    rs.getString("test_normal_value"),
                    rs.getString("test_value"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                testResultList.add(testResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResultList;
    }

    public void updateTestResult(TestResult testResult) {
        String query = "UPDATE test_result SET date=?, test_type=?, test_name=?, test_normal_value=?, test_value=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(testResult.getDate().getTime()));
            ps.setString(2, testResult.getTestType());
            ps.setString(3, testResult.getTestName());
            ps.setString(4, testResult.getTestNormalValue());
            ps.setString(5, testResult.getTestValue());
            ps.setString(6, testResult.getName());
            ps.setInt(7, testResult.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTestResult(int id) {
        String query = "DELETE FROM test_result WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TestResult getTestResultById(int id) {
        TestResult testResult = null;
        String query = "SELECT * FROM test_result WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    testResult = new TestResult(
                        rs.getDate("date"),
                        rs.getString("test_type"),
                        rs.getString("test_name"),
                        rs.getString("test_normal_value"),
                        rs.getString("test_value"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResult;
    }
}
