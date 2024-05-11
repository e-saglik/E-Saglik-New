package Controller;

import Entity.Admin;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminController extends BaseController<Admin> {

    public AdminController() {
        
    }
    
    @Override
    public void AddEntity(Admin admin){
        
    }
    
    @Override
    public Admin GetEntityById(int id){       
        return null;      
    }
    
    @Override
    public List<Admin> GetEntityList(){
        return null;  
    }
    
    @Override
    public void UpdateEntity(int id){
        
    }
    
    @Override
    public void DeleteEntity(int id){
        
    }
}
