package Controller;

import DAO.BaseDAO;
import Entity.Payment;
import java.util.List;

public class PaymentController extends BaseController<Payment> {

    private BaseDAO paymentDao;
    private Payment payment;
    private List<Payment> paymentList;

    
    public PaymentController() {
        
    }   
    
    @Override
    public void AddEntity(Payment payment){
        
    }
    
    @Override
    public Payment GetEntityById(int id){       
        return null;      
    }
    
    @Override
    public List<Payment> GetEntityList(){
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
