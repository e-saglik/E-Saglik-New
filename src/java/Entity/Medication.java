package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Medication")
public class Medication extends BaseEntity {
    @Column(name = "dosage")
    private String dosage;
    
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Medication() {
    
    }

    public Medication(String dosage, Prescription prescription, int id, String name) {
        super(id, name);
        this.dosage = dosage;
        this.prescription = prescription;
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

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dosage='" + dosage + '\'' +
                ", prescription=" + prescription +
                '}';
    }
}
