package DAO;

import Entity.Donation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonationDAO extends BaseDAO<Donation> {

    public DonationDAO(Connection connection) {
        super(connection);
    }

    public DonationDAO() {
    }

    public void CreateDonation(Donation donation) {
        String query = "INSERT INTO donation (donation_type, donor_name, donation_date, id, name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, donation.getDonationType());
            ps.setString(2, donation.getDonorName());
            ps.setDate(3, new java.sql.Date(donation.getDonationDate().getTime()));
            ps.setInt(4, donation.getId());
            ps.setString(5, donation.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Donation> GetDonationList() {
        List<Donation> donationList = new ArrayList<>();
        String query = "SELECT * FROM donation ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Donation donation = new Donation(
                    rs.getString("donation_type"),
                    rs.getString("donor_name"),
                    rs.getDate("donation_date"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                donationList.add(donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donationList;
    }

    public void UpdateDonation(Donation donation) {
        String query = "UPDATE donation SET donation_type=?, donor_name=?, donation_date=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, donation.getDonationType());
            ps.setString(2, donation.getDonorName());
            ps.setDate(3, new java.sql.Date(donation.getDonationDate().getTime()));
            ps.setString(4, donation.getName());
            ps.setInt(5, donation.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteDonation(int id) {
        String query = "DELETE FROM donation WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Donation GetDonationById(int id) {
        Donation donation = null;
        String query = "SELECT * FROM donation WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    donation = new Donation(
                        rs.getString("donation_type"),
                        rs.getString("donor_name"),
                        rs.getDate("donation_date"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donation;
    }
}
