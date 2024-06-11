package Entity;

import java.time.LocalTime;
import java.util.Date;

public class Appointment extends BaseEntity {
    private Date appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private PolyClinic polyClinic;
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Date appointmentDate, LocalTime appointmentTime, String status, PolyClinic polyClinic, Patient patient, int id, String name) {
        super(id, name);
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.polyClinic = polyClinic;
        this.patient = patient;
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

    public PolyClinic getPolyClinic() {
        return polyClinic;
    }

    public void setPolyClinic(PolyClinic polyClinic) {
        this.polyClinic = polyClinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
      @Override
    public String toString() {
        return "Appointment{" +
            "appointmentDate=" + appointmentDate +
            ", appointmentTime=" + appointmentTime +
            ", status=" + status +
            ", polyClinic=" + polyClinic +
            '}';
    }
    
        
}
