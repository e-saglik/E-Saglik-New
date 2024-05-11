package Entity;

import java.time.LocalTime;
import java.util.Date;

public class Appointment extends BaseEntity {
    private Date appointmentDate;
    private LocalTime appointmentTime;
    private String status;

    public Appointment() {
    }

    public Appointment(Date appointmentDate, LocalTime appointmentTime, String status, int id, String name) {
        super(id, name);
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }    
    
    private void confirmAppointment(){
        
    }
    private void rescheduleAppointment(){
        
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime + ", status=" + status + '}';
    }
        
}
