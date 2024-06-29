package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor extends User {

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "appointment")
    private String appointment;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

    @ManyToMany
    private Set<Role> roles;

    public Doctor() {
    }

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, List<Patient> patientList, Set<Role> roles, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
        this.patientList = patientList;
        this.roles = roles;
    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
    }

    public void prescribeMedication() {
        // Implementation
    }

    public void requestTest() {
        // Implementation
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization='" + specialization + '\'' +
                ", hospital='" + hospital + '\'' +
                ", prescription='" + prescription + '\'' +
                ", appointment='" + appointment + '\'' +
                ", patientList=" + patientList +
                ", roles=" + roles +
                '}';
    }
}
