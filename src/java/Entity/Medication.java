package Entity;

public class Medication extends BaseEntity {
    private String dosage;

    public Medication() {
    
    }

    public Medication(String dosage, int id, String name) {
        super(id, name);
        this.dosage = dosage;
    }

    

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dısage) {
        this.dosage = dısage;
    }

    @Override
    public String toString() {
        return "Medication{" + "dosage=" + dosage + '}';
    }
    
}
