
package Main;

import Controller.BaseController;
import Controller.UserController;
import Converter.DoctorConverter;
import Entity.Doctor;
import Entity.Patient;
import Entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        DoctorConverter DC = new DoctorConverter();
        String doctorString = "Doctor{" +
        "id=1" +
        ", name='John Doe'" +
        ", firstName='John'" +
        ", lastName='Doe'" +
        ", email='johndoe@example.com'" +
        ", password='mypassword'" +
        ", gender='Male'" +
        ", phoneNumber='1234567890'" +
        ", address='123 Main Street City'" +
        ", specialization='Cardiology'" +
        ", hospital='City Hospital'" +
        ", prescription='Aspirin, 100mg'" +
        ", appointment='2024-05-11 10:00 AM'" +
        ", patientList=[101, 102, 103]" +
        '}';


        try {
            Doctor d = DC.ConvertToEntity(doctorString);
            String s = DC.ConvertToString(d);
            System.out.println(s);
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
