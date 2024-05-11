package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class DoctorController extends BaseController<Doctor> {

    private Doctor doctor;
    private DoctorDAO dao;
    private List<Doctor> list;

    public String create() {

        this.getDao().createDoctor(this.doctor);

        return "index";

    }

    public Doctor getEntity() {
        if (this.doctor == null) {
            this.doctor = new Doctor();
        }
        return doctor;
    }

    public void setEntity(Doctor Entity) {
        this.doctor = Entity;
    }

    public DoctorDAO getDao() {
        if (this.dao == null) {
            this.dao = new DoctorDAO();
        }
        return dao;
    }

    public void setDao(DoctorDAO dao) {
        this.dao = dao;
    }

    public List<Doctor> getList() {
        this.list = this.getDao().getDoctorList();
        return list;
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public DoctorController() {

    }

    @Override
    public void AddEntity(Doctor doctor) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.createDoctor(doctor);

    }

    @Override
    public Doctor GetEntityById(int id) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.getDoctorById(id);
        return null;
    }

    @Override
    public List<Doctor> GetEntityList() {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.getDoctorList();

        return dao.getDoctorList();
    }

    @Override
    public void UpdateEntity(int id, Doctor doctor) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.updateDoctor(doctor);
    }

    @Override
    public void DeleteEntity(int id) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.deleteDoctor(id);
    }
}
