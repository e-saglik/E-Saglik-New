package Controller;

import DAO.AbstractDAO;
import Entity.Insurance;
import java.util.List;

public class InsuranceController extends BaseController<Insurance> {

    public AbstractDAO getInsuranceDao() {
        return ınsuranceDao;
    }

    public void setInsuranceDao(AbstractDAO ınsuranceDao) {
        this.ınsuranceDao = ınsuranceDao;
    }

    public Insurance getInsurance() {
        return ınsurance;
    }

    public void setInsurance(Insurance ınsurance) {
        this.ınsurance = ınsurance;
    }

    public List<Insurance> getInsuranceList() {
        return ınsuranceList;
    }

    public void setInsuranceList(List<Insurance> ınsuranceList) {
        this.ınsuranceList = ınsuranceList;
    }

    private AbstractDAO ınsuranceDao;
    private Insurance ınsurance;
    private List<Insurance> ınsuranceList;

    public InsuranceController() {

    }

    @Override
    public void AddEntity(Insurance insurance) {

    }

    @Override
    public Insurance GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Insurance> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Insurance ınsurance) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
