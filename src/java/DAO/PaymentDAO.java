package DAO;

import Entity.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends BaseDAO<Payment> {

    public PaymentDAO(Connection connection) {
        super(connection);
    }

    public PaymentDAO() {
    }

    public void createPayment(Payment payment) {
        String query = "INSERT INTO payment (payment_amount, payment_date, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDouble(1, payment.getPaymentAmount());
            ps.setDate(2, new java.sql.Date(payment.getPaymentDate().getTime()));
            ps.setInt(3, payment.getId());
            ps.setString(4, payment.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getPaymentList() {
        List<Payment> paymentList = new ArrayList<>();
        String query = "SELECT * FROM payment ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Payment payment = new Payment(
                    rs.getDouble("payment_amount"),
                    rs.getDate("payment_date"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentList;
    }

    public void updatePayment(Payment payment) {
        String query = "UPDATE payment SET payment_amount=?, payment_date=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDouble(1, payment.getPaymentAmount());
            ps.setDate(2, new java.sql.Date(payment.getPaymentDate().getTime()));
            ps.setString(3, payment.getName());
            ps.setInt(4, payment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePayment(int id) {
        String query = "DELETE FROM payment WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Payment getPaymentById(int id) {
        Payment payment = null;
        String query = "SELECT * FROM payment WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    payment = new Payment(
                        rs.getDouble("payment_amount"),
                        rs.getDate("payment_date"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
}
