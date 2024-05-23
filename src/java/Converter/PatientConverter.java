package Converter;

import Entity.Admin;
import Entity.Patient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientConverter extends BaseConverter<Patient> {

    public PatientConverter() {
        super();
    }

    @Override
    public String ConvertToString(Patient patient) {
        return "Patient{"
                + "dateOfBirth=" + patient.getDateOfBirth()
                + ", bloodType='" + patient.getBloodType() + '\''
                + ", appointment='" + patient.getAppointment() + '\''
                + ", medicationList=" + patient.getMedicationList()
                + ", medicalReportList=" + patient.getMedicalReportList()
                + ", testResultList=" + patient.getTestResultList()
                + ", diseaseList=" + patient.getDiseaseList()
                + ", allergyList=" + patient.getAllergyList()
                + ", insurance='" + patient.getInsurance() + '\''
                + ", vaccinationSchedule='" + patient.getVaccinationSchedule() + '\''
                + ", treatmentList=" + patient.getTreatmentList()
                + ", paymentList=" + patient.getPaymentList()
                + ", notificationList=" + patient.getNotificationList()
                + ", firstName='" + patient.getFirstName() + '\''
                + ", lastName='" + patient.getLastName() + '\''
                + ", email='" + patient.getEmail() + '\''
                + ", password='" + patient.getPassword() + '\''
                + ", gender='" + patient.getGender() + '\''
                + ", phoneNumber='" + patient.getPhoneNumber() + '\''
                + ", address='" + patient.getAddress() + '\''
                + ", id=" + patient.getId()
                + ", name='" + patient.getName() + '\''
                + '}';
    }

    @Override
    public Patient ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Patient patient = new Patient();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            patient.setId(Integer.parseInt(idString));
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
                    case "dateOfBirth":
                        patient.setDateOfBirth(new Date(value)); // Assuming a proper Date conversion
                        break;
                    case "bloodType":
                        patient.setBloodType(value);
                        break;
                    case "appointment":
                        patient.setAppointment(value);
                        break;
                    case "medicationList":
                        patient.setMedicationList(convertToIntegerList(value));
                        break;
                    case "medicalReportList":
                        patient.setMedicalReportList(convertToIntegerList(value));
                        break;
                    case "testResultList":
                        patient.setTestResultList(convertToIntegerList(value));
                        break;
                    case "diseaseList":
                        patient.setDiseaseList(convertToIntegerList(value));
                        break;
                    case "allergyList":
                        patient.setAllergyList(convertToIntegerList(value));
                        break;
                    case "insurance":
                        patient.setInsurance(value);
                        break;
                    case "vaccinationSchedule":
                        patient.setVaccinationSchedule(value);
                        break;
                    case "treatmentList":
                        patient.setTreatmentList(convertToStringList(value));
                        break;
                    case "paymentList":
                        patient.setPaymentList(convertToStringList(value));
                        break;
                    case "notificationList":
                        patient.setNotificationList(convertToStringList(value));
                        break;
                    case "firstName":
                        patient.setFirstName(value);
                        break;
                    case "lastName":
                        patient.setLastName(value);
                        break;
                    case "email":
                        patient.setEmail(value);
                        break;
                    case "password":
                        patient.setPassword(value);
                        break;
                    case "gender":
                        patient.setGender(value);
                        break;
                    case "phoneNumber":
                        patient.setPhoneNumber(value);
                        break;
                    case "address":
                        patient.setAddress(value);
                        break;
                    case "id":
                        patient.setId(Integer.parseInt(value));
                        break;
                    case "name":
                        patient.setName(value);
                        break;
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return patient;
    }

    private List<Integer> convertToIntegerList(String value) {
        // Assuming the value format is something like "[1, 2, 3]"
        value = value.replace("[", "").replace("]", "");
        String[] parts = value.split(", ");
        List<Integer> list = new ArrayList<>();
        for (String part : parts) {
            list.add(Integer.parseInt(part));
        }
        return list;
    }

    private List<String> convertToStringList(String value) {
        // Assuming the value format is something like "[a, b, c]"
        value = value.replace("[", "").replace("]", "");
        String[] parts = value.split(", ");
        return Arrays.asList(parts);
    }

}
