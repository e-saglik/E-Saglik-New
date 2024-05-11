package Controller;

import DAO.BaseDAO;
import Entity.Medication;
import java.util.List;

public class MedicationController extends BaseController<Medication> {

    public BaseDAO getMedicationDao() {
        return medicationDao;
    }

    public void setMedicationDao(BaseDAO medicationDao) {
        this.medicationDao = medicationDao;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    private BaseDAO medicationDao;
    private Medication medication;
    private List<Medication> medicationList;

    public MedicationController() {

    }

    @Override
    public void AddEntity(Medication medication) {

    }

    @Override
    public Medication GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Medication> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Medication medication) {

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
