package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication extends BaseEntity {
    @Column(name = "dosage")
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Medication() {
    }

    public Medication(String dosage, Prescription prescription, Patient patient, int id, String name) {
        super(id, name);
        this.dosage = dosage;
        this.prescription = prescription;
        this.patient = patient;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dosage='" + dosage + '\'' +
                ", prescription=" + prescription +
                ", patient=" + patient +
                '}';
    }
}
