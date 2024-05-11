package Entity;

import java.util.Date;

public class Notification extends BaseEntity {
    private String massage;
    private Date notificationDate;

    public Notification() {
    
    }

    public Notification(String massage, Date notificationDate, int id, String name) {
        super(id, name);
        this.massage = massage;
        this.notificationDate = notificationDate;
    }

    

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Override
    public String toString() {
        return "Notification{" + "massage=" + massage + ", notificationDate=" + notificationDate + '}';
    }
    
    
}
