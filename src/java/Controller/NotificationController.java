package Controller;

import DAO.AbstractDAO;
import DAO.NotificationDAO;
import Entity.Notification;
import java.util.List;

public class NotificationController extends BaseController<Notification> {

    private NotificationDAO notificationDao;
    private Notification notification;
    private List<Notification> notificationList;

    public NotificationController() {

    }

    public AbstractDAO getNotificationDao() {
        return notificationDao;
    }

    public void setNotificationDao(NotificationDAO notificationDao) {
        this.notificationDao = notificationDao;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public void AddEntity(Notification notification) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.CreateNotification(notification);

    }

    @Override
    public Notification GetEntityById(int id) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.getNotificationById(id);
        return null;
    }

    @Override
    public List<Notification> GetEntityList() {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.getNotificationList();

        return notificationDao.getNotificationList();
    }

    @Override
    public void UpdateEntity(int id, Notification notification) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.UpdateNotification(notification);
    }

    @Override
    public void DeleteEntity(int id) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.DeleteNotification(id);
    }

}
