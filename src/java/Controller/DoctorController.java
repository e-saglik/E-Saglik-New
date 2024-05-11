package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class DoctorController extends BaseController<Doctor> {

    private Doctor entity;
    private DoctorDAO dao;
    private List<Doctor> list;

    public Doctor getEntity() {
        if (this.entity == null) {
            this.entity = new Doctor();
        }
        return entity;
    }

    public void setEntity(Doctor Entity) {
        this.entity = Entity;
    }

    public DoctorDAO getDao() {
        if(this.dao == null){
            this.dao = new DoctorDAO();
        }
        return dao;
    }

    public void setDao(DoctorDAO dao) {
        this.dao = dao;
    }

    public List<Doctor> getList() {
        return list;
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public DoctorController() {

    }

    @Override
    public void AddEntity(Doctor doctor) {
        DoctorDAO dao = new DoctorDAO();
        dao.createDoctor(doctor);

    }

    @Override
    public Doctor GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Doctor> GetEntityList() {
        DoctorDAO dao = new DoctorDAO();
        return dao.getDoctorList();
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }
}
