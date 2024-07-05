package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User {

    @Column(name = "authorization_level")
    private String authorizationLevel;

    public Admin() {
    }

    public Admin(String authorizationLevel, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address) {
        super(firstName, lastName, email, password, gender, phoneNumber, address);
        this.authorizationLevel = authorizationLevel;
    }

  
    
    public void addDoctor() {
        // Implementasyon
    }

    public void addPatient() {
        // Implementasyon
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    @Override
    public String toString() {
        return "Admin{" + "authorizationLevel=" + authorizationLevel + ", " + super.toString() + '}';
    }
}
