package Converter;

import Entity.Admin;
import Entity.Prescription;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrescriptionConverter extends BaseConverter<Prescription> {

    public PrescriptionConverter() {
        super();
    }

    @Override
    public String ConvertToString(Prescription prescription) {
        StringBuilder medicationListString = new StringBuilder();
        for (Integer medication : prescription.getMedicationList()) {
            medicationListString.append(medication).append(",");
        }
        // Remove the last comma if there are medications
        if (medicationListString.length() > 0) {
            medicationListString.deleteCharAt(medicationListString.length() - 1);
        }

        return "Prescription{"
                + "id=" + prescription.getId()
                + ", name='" + prescription.getName() + '\''
                + ", dosage='" + prescription.getDosage() + '\''
                + ", medicationList=" + medicationListString.toString()
                + ", instructions='" + prescription.getInstructions() + '\''
                + '}';
    }

    @Override
    public Prescription ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Prescription prescription = new Prescription();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            prescription.setId(Integer.parseInt(idString));
        } else {
            System.out.println("ID not found.");
        }
        String[] parts = string.split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                switch (key) {
                    case "name":
                        prescription.setName(value);
                        break;
                    case "dosage":
                        prescription.setDosage(value);
                        break;
                    case "instructions":
                        prescription.setInstructions(value);
                        break;
                    case "medicationList":
                        List<Integer> medicationList = extractMedicationList(value);
                        prescription.setMedicationList(medicationList);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return prescription;
    }

    private List<Integer> extractMedicationList(String value) {
        List<Integer> medicationList = new ArrayList<>();
        String[] medications = value.split(",");
        for (String medication : medications) {
            try {
                medicationList.add(Integer.parseInt(medication));
            } catch (NumberFormatException e) {
                System.out.println("Invalid medication number: " + medication);
            }
        }
        return medicationList;
    }

}
