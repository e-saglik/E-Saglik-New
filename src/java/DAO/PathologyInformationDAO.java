package DAO;

import Entity.PathologyInformation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PathologyInformationDAO extends BaseDAO<PathologyInformation> {

    public PathologyInformationDAO(Connection connection) {
        super(connection);
    }

    public PathologyInformationDAO() {
    }

    public void createPathologyInformation(PathologyInformation pathologyInformation) {
        String query = "INSERT INTO pathology_information (information_date, information, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(pathologyInformation.getInformationDate().getTime()));
            ps.setString(2, pathologyInformation.getInformation());
            ps.setInt(3, pathologyInformation.getId());
            ps.setString(4, pathologyInformation.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PathologyInformation> getPathologyInformationList() {
        List<PathologyInformation> pathologyInformationList = new ArrayList<>();
        String query = "SELECT * FROM pathology_information ORDER BY id ASC";
        try (Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                PathologyInformation pathologyInformation = new PathologyInformation(
                    rs.getDate("information_date"),
                    rs.getString("information"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                pathologyInformationList.add(pathologyInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pathologyInformationList;
    }

    public void updatePathologyInformation(PathologyInformation pathologyInformation) {
        String query = "UPDATE pathology_information SET information_date=?, information=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(pathologyInformation.getInformationDate().getTime()));
            ps.setString(2, pathologyInformation.getInformation());
            ps.setString(3, pathologyInformation.getName());
            ps.setInt(4, pathologyInformation.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePathologyInformation(int id) {
        String query = "DELETE FROM pathology_information WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PathologyInformation getPathologyInformationById(int id) {
        PathologyInformation pathologyInformation = null;
        String query = "SELECT * FROM pathology_information WHERE id=?";
        try (PreparedStatement ps = this.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pathologyInformation = new PathologyInformation(
                        rs.getDate("information_date"),
                        rs.getString("information"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pathologyInformation;
    }
}
