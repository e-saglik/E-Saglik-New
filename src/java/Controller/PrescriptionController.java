package Controller;

import DAO.AbstractDAO;
import DAO.PrescriptionDAO;
import Entity.Prescription;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PrescriptionController extends BaseController<Prescription> implements Serializable{

    private Prescription entity;
    @EJB
    private PrescriptionDAO prescriptionDao;
    private Prescription prescription;
    private List<Prescription> prescriptionList;


    private List<Prescription> list;
    
    
     private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    public PrescriptionController() {
        super(Prescription.class);
    }

    public PrescriptionDAO getPrescriptionDao() {
        if (this.prescriptionDao == null) {
            this.prescriptionDao = new PrescriptionDAO();
        }
        return prescriptionDao;
    }

    public void setPrescriptionDao(PrescriptionDAO prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
    
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
        this.pageCount = (int) Math.ceil(getPrescriptionDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Prescription();
    }

    public void updateForm(Prescription doc) {
        this.entity = doc;
    }



   @Override
    public Prescription GetEntityById(int id) {
        if (prescriptionDao == null) {
            prescriptionDao = new PrescriptionDAO();
        }
        prescriptionDao.GetById(id);
        return null;
    }

    @Override
    public List<Prescription> GetEntityList() {  
        return  getPrescriptionDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getPrescriptionDao().Update(entity);
        entity = new Prescription();       
    }

    @Override
    public void DeleteEntity() {
        getPrescriptionDao().Delete(entity);
        entity = new Prescription();       
    }

    @Override
    public void AddEntity() {
        getPrescriptionDao().Create(entity);
        entity = new Prescription();       
    }

    public Prescription getEntity() {
        return entity;
    }

    public void setEntity(Prescription entity) {
        this.entity = entity;
    }

    public List<Prescription> getList() {
        return list;
    }

    public void setList(List<Prescription> list) {
        this.list = list;
    }
    
    

}
