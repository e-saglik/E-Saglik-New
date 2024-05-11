package Controller;

import DAO.BaseDAO;
import Entity.MedicalReport;
import java.util.List;

public class MedicalReportController extends BaseController<MedicalReport> {

    public BaseDAO getMedicalReportDao() {
        return medicalReportDao;
    }

    public void setMedicalReportDao(BaseDAO medicalReportDao) {
        this.medicalReportDao = medicalReportDao;
    }

    public MedicalReport getMedicalReport() {
        return medicalReport;
    }

    public void setMedicalReport(MedicalReport medicalReport) {
        this.medicalReport = medicalReport;
    }

    public List<MedicalReport> getMedicalReportList() {
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    private BaseDAO medicalReportDao;
    private MedicalReport medicalReport;
    private List<MedicalReport> medicalReportList;

    public MedicalReportController() {

    }

    @Override
    public void AddEntity(MedicalReport medicalReport) {

    }

    @Override
    public MedicalReport GetEntityById(int id) {
        return null;
    }

    @Override
    public List<MedicalReport> GetEntityList() {
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
