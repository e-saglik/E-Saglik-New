package Entity;
import java.util.List;

public class Prescription extends BaseEntity {
    private String dosage;
    private List<Integer> medicationList;
    private String instructions;

    public Prescription() {
        
    }

    public Prescription(String dosage, List<Integer> medicationList, String instructions, int id, String name) {
        super(id, name);
        this.dosage = dosage;
        this.medicationList = medicationList;
        this.instructions = instructions;
    }

    

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public List<Integer> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Integer> medicationList) {
        this.medicationList = medicationList;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Prescription{" + "dosage=" + dosage + ", medicationList=" + medicationList + ", instructions=" + instructions + '}';
    }
    
    
}
