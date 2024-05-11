package Converter;
import Entity.Doctor; 
import Entity.Hospital;
import Entity.Notification;
import Entity.Patient;
import jakarta.mail.internet.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationConverter extends BaseConverter<Notification> {

    public NotificationConverter() {
        super();
    }

    @Override
    public String ConvertToString(Notification notification) {
       return "Doctor{" +
            "id=" + notification.getId() +
            ", name='" + notification.getName() + '\'' +
            ", firstName='" + notification.getMassage()+ '\'' +
            ", lastName='" + notification.getNotificationDate()+ '\'' + 
            '}';
    }
    
    @Override
    public Notification ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        Notification notification = new Notification();
        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            notification.setId(Integer.parseInt(idString));
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
                        notification.setName(value);
                        break;
                    case "massage":
                        notification.setMassage(value);
                        break;
                        
                    case "notification date":
                         String format = "dd-mm-yyyy";
                         
                    {
                        try {
                            notification.setNotificationDate(convertStringToDate(value, format));
                        } catch (ParseException ex) {
                            Logger.getLogger(NotificationConverter.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (java.text.ParseException ex) {
                            Logger.getLogger(NotificationConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;     
     
                    default:
                        // Handle unknown key or ignore
                        break;
                }
            }
        }
        return notification;
    }
    public static Date convertStringToDate(String dateString, String format) throws ParseException, java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateString);
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
