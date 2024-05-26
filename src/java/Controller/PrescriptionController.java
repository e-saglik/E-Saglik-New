package Controller;

import DAO.BaseDAO;
import DAO.PrescriptionDAO;
import Entity.Prescription;
import java.util.List;

public class PrescriptionController extends BaseController<Prescription> {

    public BaseDAO getPrescriptionDao() {
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

    public PrescriptionController() {

    }


   @Override
    public Prescription GetEntityById(int id) {
        if (prescriptionDao == null) {
            prescriptionDao = new PrescriptionDAO();
        }
        prescriptionDao.GetPrescriptionById(id);
        return null;
    }

    @Override
    public List<Prescription> GetEntityList() {
        if (prescriptionDao == null) {
            prescriptionDao = new PrescriptionDAO();
        }
        prescriptionDao.GetPrescriptionList();

        return prescriptionDao.GetPrescriptionList();
    }

    @Override
    public void UpdateEntity(int id, Prescription payment) {
        if (prescriptionDao == null) {
            prescriptionDao = new PrescriptionDAO();
        }
        prescriptionDao.UpdatePrescription(prescription);
    }

    @Override
    public void DeleteEntity(int id) {
        if (prescriptionDao == null) {
            prescriptionDao = new PrescriptionDAO();
        }
        prescriptionDao.DeletePrescription(id);
    }

}
