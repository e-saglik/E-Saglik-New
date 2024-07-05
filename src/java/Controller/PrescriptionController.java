package Controller;

import DAO.AbstractDAO;
import DAO.DoctorDAO;
import DAO.PrescriptionDAO;
import Entity.Doctor;
import Entity.Prescription;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PrescriptionController extends BaseController<Prescription> implements Serializable{

    private Prescription entity;
    @EJB
    private PrescriptionDAO dao;

    private List<Prescription> list;
    
    public PrescriptionController() {
        super(Prescription.class);
    }

    public AbstractDAO getPrescriptionDao() {
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

    private PrescriptionDAO prescriptionDao;
    private Prescription prescription;
    private List<Prescription> prescriptionList;


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
        return  getDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDao().Update(entity);
        entity = new Prescription();       
    }

    @Override
    public void DeleteEntity() {
        getDao().Delete(entity);
        entity = new Prescription();       
    }

    @Override
    public void AddEntity() {
        getDao().Create(entity);
        entity = new Prescription();       
    }

    public Prescription getEntity() {
        return entity;
    }

    public void setEntity(Prescription entity) {
        this.entity = entity;
    }

    public PrescriptionDAO getDao() {
        return dao;
    }

    public void setDao(PrescriptionDAO dao) {
        this.dao = dao;
    }

    public List<Prescription> getList() {
        return list;
    }

    public void setList(List<Prescription> list) {
        this.list = list;
    }
    
    

}
