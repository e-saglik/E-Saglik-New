package Converter;

import Entity.Medication;

public class MedicationConverter extends BaseConverter<Medication> {

    public MedicationConverter() {
    }
    
    @Override
    public String ConvertToString(Medication medication) {
        return "Medication{" +
            "dosage='" + medication.getDosage()+ '\'' +
            ", id=" + medication.getId() +
            ", name='" + medication.getName() + '\'' +
            '}';
    }
    
    @Override
    public Medication ConvertToEntity(String input) {
        String[] parts = input.split("[=,}]");

        String dosage = parts[1].replaceAll("'", "").trim();
        int id = Integer.parseInt(parts[3].trim());
        String name = parts[5].replaceAll("'", "").trim();

        return new Medication(dosage, id , name);
    }
    
}
