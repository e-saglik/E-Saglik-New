package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
@Named
@ViewScoped
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
        DoctorDAO dao = new DoctorDAO();
        return dao.getDoctorList();   
    }
    
    @Override
    public void UpdateEntity(int id){
        
    }
    
    @Override
    public void DeleteEntity(int id){
        
    }
}
