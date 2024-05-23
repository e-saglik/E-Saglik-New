package Entity;

import java.util.Date;

public class Notification extends BaseEntity {
    private String message;
    private Date notificationDate;

    public Notification() {
    
    }

    public Notification(String massage, Date notificationDate, int id, String name) {
        super(id, name);
        this.message = massage;
        this.notificationDate = notificationDate;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Override
    public String toString() {
        return "Notification{" + "massage=" + message + ", notificationDate=" + notificationDate + '}';
    }
    
    
}
