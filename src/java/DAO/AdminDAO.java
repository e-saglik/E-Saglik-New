package DAO;

import Entity.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends BaseDAO<Admin> {

    public AdminDAO(Connection connection) {
        super(connection);
    }

    public AdminDAO() {
        
    }
    
    

    

    public void createAdmin(Admin admin) {
        String query = "INSERT INTO admin (authorization_level, first_name, last_name, email, password, gender, phone_number, address, id, name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, admin.getAuthorizationLevel());
            ps.setString(2, admin.getFirstName());
            ps.setString(3, admin.getLastName());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getGender());
            ps.setString(7, admin.getPhoneNumber());
            ps.setString(8, admin.getAddress());
            ps.setInt(9, admin.getId());
            ps.setString(10, admin.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAdminList() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Admin admin = new Admin(rs.getString("authorization_level"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone_number"), rs.getString("address"), rs.getInt("id"), rs.getString("name"));
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    public void updateAdmin(Admin admin) {
        String query = "UPDATE admin SET authorization_level=?, first_name=?, last_name=?, email=?, password=?, gender=?, phone_number=?, address=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setString(1, admin.getAuthorizationLevel());
            ps.setString(2, admin.getFirstName());
            ps.setString(3, admin.getLastName());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getGender());
            ps.setString(7, admin.getPhoneNumber());
            ps.setString(8, admin.getAddress());
            ps.setString(9, admin.getName());
            ps.setInt(10, admin.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        String query = "DELETE FROM admin WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin getAdminById(int id) {
        Admin admin = null;
        String query = "SELECT * FROM admin WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin(rs.getString("authorization_level"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone_number"), rs.getString("address"), rs.getInt("id"), rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
