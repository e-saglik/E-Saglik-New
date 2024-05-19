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

    public String updateForm(Doctor doc) {
        this.doctor = doc;
        return "index";
    }

    public String update() {
        this.getDao().UpdateDoctor(this.doctor);
        return "index";
    }

    public String create() {

        this.getDao().CreateDoctor(this.doctor);

        return "index";

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
        this.list = this.getDao().GetDoctorList();
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
        dao.CreateDoctor(doctor);

    }

    @Override
    public Doctor GetEntityById(int id) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.GetDoctorById(id);
        return null;
    }

    @Override
    public List<Doctor> GetEntityList() {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.GetDoctorList();

        return dao.GetDoctorList();
    }

    @Override
    public void UpdateEntity(int id, Doctor doctor) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.UpdateDoctor(doctor);
    }

    @Override
    public void DeleteEntity(int id) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.DeleteDoctor(id);
    }
    
}
