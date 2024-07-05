package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")
public class Doctor extends User implements Serializable {


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
        // Default constructor
    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
    }
    
    

    // Getters and setters

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

    // toString() method for debugging and logging purposes
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", hospital='" + hospital + '\'' +
                ", prescription='" + prescription + '\'' +
                ", appointment='" + appointment + '\'' +
                '}';
    }
}
