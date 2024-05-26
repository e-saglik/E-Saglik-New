package Controller;

import DAO.BaseDAO;
import Entity.Hospital;
import java.util.List;

public class HospitalController extends BaseController<Hospital> {

    private BaseDAO hospitalDao;
    private Hospital hospital;
    private List<Hospital> hospitalList;

    public BaseDAO getHospitalDao() {
        return hospitalDao;
    }

    public void setHospitalDao(BaseDAO hospitalDao) {
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

    }

    @Override
    public Hospital GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Hospital> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Hospital hospital) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
