package Controller;

import DAO.BaseDAO;
import Entity.Payment;
import Entity.Pharmacy;
import java.util.List;

public class PharmacyController extends BaseController<Pharmacy> {

    public BaseDAO getPharmacyDao() {
        return pharmacyDao;
    }

    public void setPharmacyDao(BaseDAO pharmacyDao) {
        this.pharmacyDao = pharmacyDao;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Pharmacy> getPharmacyList() {
        return pharmacyList;
    }

    public void setPharmacyList(List<Pharmacy> pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    private BaseDAO pharmacyDao;
    private Pharmacy pharmacy;
    private List<Pharmacy> pharmacyList;

    public PharmacyController() {

    }

    @Override
    public void AddEntity(Pharmacy pharmacy) {

    }

    @Override
    public Pharmacy GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Pharmacy> GetEntityList() {
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
