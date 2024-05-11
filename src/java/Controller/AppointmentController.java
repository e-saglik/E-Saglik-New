package Controller;

import DAO.AppointmentDAO;
import Entity.Appointment;
import java.util.List;

public class AppointmentController extends BaseController<Appointment> {

    private AppointmentDAO appointmentDao;
    private Appointment appointment;
    private List<Appointment> appointmentList;

    public AppointmentController() {

    }

    @Override
    public void AddEntity(Appointment appointment) {

    }

    @Override
    public Appointment GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Appointment> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

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
