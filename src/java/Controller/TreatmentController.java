package Controller;

import DAO.AbstractDAO;
import DAO.TreatmentDAO;
import Entity.Treatment;
import java.util.List;

public class TreatmentController extends BaseController<Treatment> {

    public AbstractDAO getTreatmentDao() {
        return treatmentDao;
    }

    public void setTreatmentDao(TreatmentDAO treatmentDao) {
        this.treatmentDao = treatmentDao;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    private TreatmentDAO treatmentDao;
    private Treatment treatment;
    private List<Treatment> treatmentList;

    public TreatmentController() {

    }

   @Override
    public Treatment GetEntityById(int id) {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.getTreatmentById(id);
        return null;
    }

    @Override
    public List<Treatment> GetEntityList() {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.getTreatmentList();

        return treatmentDao.getTreatmentList();
    }

    @Override
    public void UpdateEntity(int id, Treatment treatment) {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.UpdateTreatment(treatment);
    }

    @Override
    public void DeleteEntity(int id) {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.DeleteTreatment(id);
    }

    @Override
    public void AddEntity(Treatment entity) {
        if (treatmentDao == null) {
            treatmentDao = new TreatmentDAO();
        }
        treatmentDao.CreateTreatment(treatment);
    }


}
