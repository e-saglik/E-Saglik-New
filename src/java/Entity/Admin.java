
package Entity;

import Entity.User;

public class Admin extends User {
    private String authorizationLevel;

    public Admin() {
        
    }

    public Admin(String authorizationLevel, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.authorizationLevel = authorizationLevel;
    }

    private void addDoctor(){
        
    }
    private void addPatient(){
        
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    @Override
    public String toString() {
        return "Admin{" + "authorizationLevel=" + authorizationLevel + '}';
    }
    

}
