package DAO;

import Entity.Radiograph;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RadiographDAO extends BaseDAO<Radiograph> {

    public RadiographDAO(Connection connection) {
        super(connection);
    }

    public RadiographDAO() {
    }

    public void createRadiograph(Radiograph radiograph) {
        String query = "INSERT INTO radiograph (RGDate, image, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(radiograph.getRGDate().getTime()));
            ps.setString(2, radiograph.getImage());
            ps.setInt(3, radiograph.getId());
            ps.setString(4, radiograph.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Radiograph> getRadiographList() {
        List<Radiograph> radiographList = new ArrayList<>();
        String query = "SELECT * FROM radiograph ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Radiograph radiograph = new Radiograph(
                    rs.getDate("RGDate"),
                    rs.getString("image"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                radiographList.add(radiograph);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return radiographList;
    }

    public void updateRadiograph(Radiograph radiograph) {
        String query = "UPDATE radiograph SET RGDate=?, image=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(radiograph.getRGDate().getTime()));
            ps.setString(2, radiograph.getImage());
            ps.setString(3, radiograph.getName());
            ps.setInt(4, radiograph.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRadiograph(int id) {
        String query = "DELETE FROM radiograph WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Radiograph getRadiographById(int id) {
        Radiograph radiograph = null;
        String query = "SELECT * FROM radiograph WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    radiograph = new Radiograph(
                        rs.getDate("RGDate"),
                        rs.getString("image"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return radiograph;
    }
}
