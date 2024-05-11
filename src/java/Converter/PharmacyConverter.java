package Converter;

import Entity.Pharmacy;

public class PharmacyConverter extends BaseConverter<Pharmacy> {

    public PharmacyConverter() {
    }
    
    @Override
    public String ConvertToString(Pharmacy medication) {
        return "Medication{" +
            "dosage='" + medication.getLocation()+ '\'' +
            ", id=" + medication.getId() +
            ", name='" + medication.getName() + '\'' +
            '}';
    }
    
    @Override
    public Pharmacy ConvertToEntity(String input) {
        String[] parts = input.split("[=,}]");

        String location = parts[1].replaceAll("'", "").trim();
        int id = Integer.parseInt(parts[3].trim());
        String name = parts[5].replaceAll("'", "").trim();

        return new Pharmacy(location, id , name);
    }
    
}
