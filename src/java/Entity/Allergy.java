package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "allergy")
public class Allergy extends BaseEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "severity")
    private int severity;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Allergy() {
    }

    public Allergy(String type, int severity, Patient patient, int id, String name) {
        super(id, name);
        this.type = type;
        this.severity = severity;
        this.patient = patient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Allergy{" + "type=" + type + ", severity=" + severity + ", patient=" + patient + '}';
    }
}
