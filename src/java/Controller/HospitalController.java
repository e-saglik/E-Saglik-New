package Controller;

import DAO.AbstractDAO;
import DAO.HospitalDAO;
import Entity.Hospital;
import java.util.List;

public class HospitalController extends BaseController<Hospital> {

    private HospitalDAO hospitalDao;
    private Hospital hospital;
    private List<Hospital> hospitalList;

    public AbstractDAO getHospitalDao() {
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDAO hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public HospitalController() {
 
    }

    @Override
    public void AddEntity(Hospital hospital) {
        if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.CreateHospital(hospital);

    }

    @Override
    public Hospital GetEntityById(int id) {
        if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.getHospitalById(id);
        return null;
    }

    @Override
    public List<Hospital> GetEntityList() {
        if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.getHospitalList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Hospital hospital) {
if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.UpdateHospital(hospital);
    }

    @Override
    public void DeleteEntity(int id) {
        if (hospitalDao == null) {
            hospitalDao = new HospitalDAO();
        }
        hospitalDao.DeleteHospital(id);
    }

}
