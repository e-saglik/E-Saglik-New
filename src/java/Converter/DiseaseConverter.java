package Converter;

import Entity.Disease;

public class DiseaseConverter extends BaseConverter<Disease> {

    public DiseaseConverter() {
    }
    
    @Override
    public String ConvertToString(Disease medication) {
        return "Medication{" +
            "dosage='" + medication.getDescription()+ '\'' +
            ", id=" + medication.getId() +
            ", name='" + medication.getName() + '\'' +
            '}';
    }
    
    @Override
    public Disease ConvertToEntity(String input) {
        String[] parts = input.split("[=,}]");

        String description = parts[1].replaceAll("'", "").trim();
        int id = Integer.parseInt(parts[3].trim());
        String name = parts[5].replaceAll("'", "").trim();

        return new Disease(description, id , name);
    }
    
}
