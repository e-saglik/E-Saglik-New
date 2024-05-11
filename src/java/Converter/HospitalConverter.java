package Converter;
import Entity.Doctor; 
import Entity.Hospital;
import Entity.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HospitalConverter extends BaseConverter<Hospital> {

    public HospitalConverter() {
        super();
    }

    @Override
    public String ConvertToString(Hospital hospital) {
       return "Doctor{" +
            "id=" + hospital.getId() +
            ", name='" + hospital.getName() + '\'' +
            ", firstName='" + hospital.getLocation()+ '\'' +
            ", lastName='" + hospital.getCapacity()+ '\'' + 
            '}';
    }
    
    @Override
    public Hospital ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Hospital hospital = new Hospital();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            hospital.setId(Integer.parseInt(idString));
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
                        hospital.setName(value);
                        break;
                    case "location":
                        hospital.setLocation(value);
                        break;
                    case "capacity":
                        hospital.setCapacity(value);
                        break;     
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return hospital;
    }
    
    

//  private List<Integer> extractPatientList(String input) {
//    List<Integer> patientList = new ArrayList<>();
//
//    // input'un null veya boş olup olmadığını kontrol edelim
//    if (input == null || input.isEmpty()) {
//        return patientList; // Boş bir liste döndürelim
//    }
//
//    // input içerisindeki diziyi alabilmek için köşeli parantezler arasındaki kısmı ayıralım
//    String[] parts = input.split("=");
//    if (parts.length != 2) {
//        return patientList; // Hatalı format için boş bir liste döndürelim
//    }
//
//    // Dizi kısmını alıp virgüllerden ayırarak integer listesine dönüştürelim
//    String arrayString = parts[1];
//    String[] numbers = arrayString.replaceAll("[\\[\\]]", "").split(", ");
//    for (String number : numbers) {
//        patientList.add(Integer.parseInt(number));
//    }
//
//    return patientList;
//}

 


}
