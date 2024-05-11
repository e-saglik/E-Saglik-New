package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import java.util.List;

public class DoctorController extends BaseController<Doctor> {

    public DoctorController() {
        
    }
    
    
    @Override
    public void AddEntity(Doctor doctor){
        DoctorDAO dao = new DoctorDAO();
        dao.createDoctor(doctor);
        
    }
    
    @Override
    public Doctor GetEntityById(int id){       
        return null;      
    }
    
    @Override
    public List<Doctor> GetEntityList(){
        return null;  
    }
    
    @Override
    public void UpdateEntity(int id){
        
    }
    
    @Override
    public void DeleteEntity(int id){
        
    }
}
