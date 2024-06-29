package DAO;

import Entity.Notification;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class NotificationDAO extends BaseDAO<Notification> {

    public NotificationDAO() {
        super();
    }

    public void createNotification(Notification notification) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(notification);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Notification> getNotificationList() {
        TypedQuery<Notification> query = getEntityManager().createQuery("SELECT n FROM Notification n ORDER BY n.id ASC", Notification.class);
        List<Notification> notificationList = query.getResultList();
        return notificationList;
    }

    public void updateNotification(Notification notification) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(notification);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteNotification(int id) {
        Notification notification = getEntityManager().find(Notification.class, id);
        if (notification != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(notification);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Notification getNotificationById(int id) {
        Notification notification = getEntityManager().find(Notification.class, id);
        return notification;
    }
}
