
package Controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NavigationController implements Serializable{
    
    public String userPage(String p){
        return "/pages/user/"+p+"?faces-redirct=true";
    }
    
    public String adminPage(String p){
        return "/pages/admin/"+p+"?faces-redirct=true";
    }
    
    public String doctorPage(String p){
        return "/pages/doctor/"+p+"?faces-redirct=true";
    }
}
