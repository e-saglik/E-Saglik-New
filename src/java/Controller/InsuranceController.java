package Controller;

import DAO.BaseDAO;
import Entity.Insurance;
import java.util.List;

public class InsuranceController extends BaseController<Insurance> {

    public BaseDAO getInsuranceDao() {
        return ınsuranceDao;
    }

    public void setInsuranceDao(BaseDAO ınsuranceDao) {
        this.ınsuranceDao = ınsuranceDao;
    }

    public Insurance getInsurance() {
        return ınsurance;
    }

    public void setInsurance(Insurance ınsurance) {
        this.ınsurance = ınsurance;
    }

    public List<Insurance> getInsuranceList() {
        return ınsuranceList;
    }

    public void setInsuranceList(List<Insurance> ınsuranceList) {
        this.ınsuranceList = ınsuranceList;
    }

    private BaseDAO ınsuranceDao;
    private Insurance ınsurance;
    private List<Insurance> ınsuranceList;

    public InsuranceController() {

    }

    @Override
    public void AddEntity(Insurance insurance) {

    }

    @Override
    public Insurance GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Insurance> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Insurance ınsurance) {

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
