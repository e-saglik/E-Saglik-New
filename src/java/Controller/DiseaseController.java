package Controller;

import DAO.DiseaseDAO;
import Entity.Disease;
import java.util.List;

public class DiseaseController extends BaseController<Disease> {

    private DiseaseDAO diseaseDao;
    private Disease disease;
    private List<Disease> diseaseList;

    public DiseaseController() {

    }

    public DiseaseDAO getDiseaseDao() {
        return diseaseDao;
    }

    public void setDiseaseDao(DiseaseDAO diseaseDao) {
        this.diseaseDao = diseaseDao;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public void AddEntity(Disease doctor) {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        //adminDao.AddAdmin(Admin);

    }

    @Override
    public Disease GetEntityById(int id) {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        //adminDao.GetDoctorById(id);
        return null;
    }

    @Override
    public List<Disease> GetEntityList() {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        //adminDao.GetDoctorList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Disease disease) {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        //adminDao.UpdateDoctor(doctor);
    }

    @Override
    public void DeleteEntity(int id) {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        //adminDao.DeleteDoctor(id);
    }

}
