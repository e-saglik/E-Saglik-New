package Controller;

import DAO.DiseaseDAO;
import Entity.Disease;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DiseaseController extends BaseController<Disease>  implements Serializable{

    @EJB
    private DiseaseDAO diseaseDao;

    private Disease disease;
    private List<Disease> diseaseList;

    public DiseaseController() {
        super(Disease.class);       
    }

    public DiseaseDAO getDiseaseDao() {
        if (this.diseaseDao == null) {
            this.diseaseDao = new DiseaseDAO();
        }
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
        this.diseaseList = this.getDiseaseDao().GetList();
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public void AddEntity() {
        getDiseaseDao().Create(this.entity);
        this.entity = new Disease();

    }

    @Override
    public Disease GetEntityById(int id) {
        if (diseaseDao == null) {
            diseaseDao = new DiseaseDAO();
        }
        diseaseDao.GetById(id);
        return null;
    }

    @Override
    public List<Disease> GetEntityList() {
        return getDiseaseDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDiseaseDao().Update(disease);
        this.entity = new Disease();
    }

    @Override
    public void DeleteEntity() {
        diseaseDao.Delete(entity);
        this.entity = new Disease();
    }

}
