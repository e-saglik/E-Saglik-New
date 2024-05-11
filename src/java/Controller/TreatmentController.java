package Controller;

import DAO.BaseDAO;
import Entity.Treatment;
import java.util.List;

public class TreatmentController extends BaseController<Treatment> {

    public BaseDAO getTreatmentDao() {
        return treatmentDao;
    }

    public void setTreatmentDao(BaseDAO treatmentDao) {
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

    private BaseDAO treatmentDao;
    private Treatment treatment;
    private List<Treatment> treatmentList;

    public TreatmentController() {

    }

    @Override
    public void AddEntity(Treatment treatment) {

    }

    @Override
    public Treatment GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Treatment> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Treatment treatment) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
