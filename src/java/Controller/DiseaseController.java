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

    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getDiseaseDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Disease();
    }

    public void updateForm(Disease dis) {
        this.entity = dis;
    }
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

    public Disease getEntity() {
        if (this.entity == null) {
            this.entity = new Disease();
        }
        return entity;
    }

    public void setEntity(Disease entity) {
        this.entity = entity;
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
