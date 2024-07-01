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
        notificationDao.Create(notification);

    }

    @Override
    public Notification GetEntityById(int id) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.GetById(id);
        return null;
    }

    @Override
    public List<Notification> GetEntityList() {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }

        return notificationDao.GetList();
    }

    @Override
    public void UpdateEntity(int id, Notification notification) {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.Update(notification);
    }

    @Override
    public void DeleteEntity() {
        if (notificationDao == null) {
            notificationDao = new NotificationDAO();
        }
        notificationDao.Delete(notification);
    }

}
