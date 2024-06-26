package Entity;

import java.util.ArrayList;
import java.util.List;

public class PolyClinic extends BaseEntity {
    private String location;
    private List<Appointment> appointments;
    private List<Doctor> doctors;

    public PolyClinic() {
    }

    public PolyClinic(int id, String name) {
        super(id, name);
    }

    public PolyClinic(String location, List<Appointment> appointments, List<Doctor> doctors, int id, String name) {
        super(id, name);
        this.location = location;
        this.appointments = appointments;
        this.doctors = doctors;
    }
   
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Appointment findAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Polyclinic{" + "location=" + location + ", appointments=" + appointments + '}';
    }
}
