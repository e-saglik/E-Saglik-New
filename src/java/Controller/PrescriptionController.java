package Controller;

import DAO.BaseDAO;
import Entity.Prescription;
import java.util.List;

public class PrescriptionController extends BaseController<Prescription> {

    public BaseDAO getPrescriptionDao() {
        return prescriptionDao;
    }

    public void setPrescriptionDao(BaseDAO prescriptionDao) {
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

    private BaseDAO prescriptionDao;
    private Prescription prescription;
    private List<Prescription> prescriptionList;

    public PrescriptionController() {

    }

    @Override
    public void AddEntity(Prescription prescription) {

    }

    @Override
    public Prescription GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Prescription> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Prescription prescription) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
