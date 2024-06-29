package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Notification")
public class Notification extends BaseEntity {
    @Column(name = "message")
    private String message;

    @Column(name = "notification_date")
    private Date notificationDate;

    public Notification() {
    
    }

    public Notification(String message, Date notificationDate, int id, String name) {
        super(id, name);
        this.message = message;
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
        return "Notification{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", message='" + message + '\'' +
                ", notificationDate=" + notificationDate +
                '}';
    }
}
