package Controller;

import Entity.User;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
@Named
@ViewScoped
public class UserController extends BaseController<User> {

    public UserController() {
        
    }   
    
    @Override
    public void AddEntity(User user){
        
    }
    
    @Override
    public User GetEntityById(int id){       
        return null;      
    }
    
    @Override
    public List<User> GetEntityList(){
        return null;  
    }
    
    @Override
    public void UpdateEntity(int id){
        
    }
    
    @Override
    public void DeleteEntity(int id){
        
    }
    
//    public void AddUser(User user){
//        
//    }
//    
//    public User GetUserById(int id){      
//        return null;        
//    }
//    
//    public List<User> GetUserList(){ 
//        return null;
//    }
//    
//    public void UpdateUser(int id,User user){
//        
//    }
//    
//    public void DeleteUser(int id){
//        
//    }
}
