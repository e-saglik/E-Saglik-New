package Controller;

import DAO.BaseDAO;
import Entity.Notification;
import java.util.List;

public class NotificationController extends BaseController<Notification> {

    private BaseDAO notificationDao;
    private Notification notification;
    private List<Notification> notificationList;

    public NotificationController() {

    }

    @Override
    public void AddEntity(Notification notification) {

    }

    public BaseDAO getNotificationDao() {
        return notificationDao;
    }

    public void setNotificationDao(BaseDAO notificationDao) {
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
    public Notification GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Notification> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
