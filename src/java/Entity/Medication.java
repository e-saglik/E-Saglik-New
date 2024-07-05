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
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Medication() {
    
    }

    public Medication(String dosage, int id, String name) {
        super(id, name);
        this.dosage = dosage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dosage='" + dosage + '\'' +
                '}';
    }
}
