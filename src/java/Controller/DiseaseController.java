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

    @Override
    public void AddEntity(Disease disease) {

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
    public Disease GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Disease> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Disease disease) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
