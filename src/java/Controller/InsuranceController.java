package Controller;

import DAO.AbstractDAO;
import DAO.InsuranceDAO;
import Entity.Insurance;
import java.util.List;

public class InsuranceController extends BaseController<Insurance> {

    private InsuranceDAO ınsuranceDao;
    private Insurance ınsurance;
    private List<Insurance> ınsuranceList;

    public InsuranceController() {

    }

    public AbstractDAO getInsuranceDao() {
        return ınsuranceDao;
    }

    public void setInsuranceDao(InsuranceDAO ınsuranceDao) {
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

    @Override
    public void AddEntity(Insurance insurance) {
        if (ınsuranceDao == null) {
            ınsuranceDao = new InsuranceDAO();
        }
        ınsuranceDao.Create(ınsurance);
    }

    @Override
    public Insurance GetEntityById(int id) {
        if (ınsuranceDao == null) {
            ınsuranceDao = new InsuranceDAO();
        }
        ınsuranceDao.getById(id);
        return null;
    }

    @Override
    public List<Insurance> GetEntityList() {
        if (ınsuranceDao == null) {
            ınsuranceDao = new InsuranceDAO();
        }
        ınsuranceDao.getEntities();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Insurance ınsurance) {
if (ınsuranceDao == null) {
            ınsuranceDao = new InsuranceDAO();
        }
        ınsuranceDao.Update(ınsurance);
    }

    @Override
    public void DeleteEntity() {
if (ınsuranceDao == null) {
            ınsuranceDao = new InsuranceDAO();
        }
        ınsuranceDao.Delete(ınsurance);
    }

}
