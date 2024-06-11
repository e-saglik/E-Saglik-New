package Entity;

public class Disease extends BaseEntity {

    private String description;
    private Patient patient;

    public Disease() {

    }

    public Disease(String description, Patient patient, int id, String name) {
        super(id, name);
        this.description = description;
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Disease{" + "description=" + description + '}';
    }

}
