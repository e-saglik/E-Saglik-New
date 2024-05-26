package DAO;

import Entity.Notification;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO extends BaseDAO<Notification> {

    public NotificationDAO(Connection connection) {
        super(connection);
    }

    public NotificationDAO() {
    }

    public void CreateNotification(Notification notification) {
        String query = "INSERT INTO notification (message, notification_date, id, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, notification.getMessage());
            ps.setDate(2, new java.sql.Date(notification.getNotificationDate().getTime()));
            ps.setInt(3, notification.getId());
            ps.setString(4, notification.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notification> GetNotificationList() {
        List<Notification> notificationList = new ArrayList<>();
        String query = "SELECT * FROM notification ORDER BY id ASC";
        try (Statement st = this.GetConnection().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Notification notification = new Notification(
                    rs.getString("message"),
                    rs.getDate("notification_date"),
                    rs.getInt("id"),
                    rs.getString("name")
                );
                notificationList.add(notification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationList;
    }

    public void UpdateNotification(Notification notification) {
        String query = "UPDATE notification SET message=?, notification_date=?, name=? WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setString(1, notification.getMessage());
            ps.setDate(2, new java.sql.Date(notification.getNotificationDate().getTime()));
            ps.setString(3, notification.getName());
            ps.setInt(4, notification.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteNotification(int id) {
        String query = "DELETE FROM notification WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Notification GetNotificationById(int id) {
        Notification notification = null;
        String query = "SELECT * FROM notification WHERE id=?";
        try (PreparedStatement ps = this.GetConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    notification = new Notification(
                        rs.getString("message"),
                        rs.getDate("notification_date"),
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notification;
    }
}
