package Controller;

import DAO.DoctorDAO;
import Entity.Doctor;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DoctorController implements Serializable {

    @Inject
    private DoctorDAO doctorDAO; // DoctorDAO dependency injection

    private Doctor entity;
    private List<Doctor> list;
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    @PostConstruct
    public void init() {
        entity = new Doctor();
    }

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(doctorDAO.Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Doctor();
    }

    public void updateForm(Doctor doc) {
        this.entity = doc;
    }

    public void update() {
        doctorDAO.Update(this.entity);
        this.entity = new Doctor();
    }

    public void create() {
        doctorDAO.Create(this.entity);
        this.entity = new Doctor();
    }

    public List<Doctor> GetEntityList() {
        this.list = doctorDAO.GetList();
        return list;
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public Doctor getEntity() {
        if (this.entity == null) {
            this.entity = new Doctor();
        }
        return entity;
    }

    public void setEntity(Doctor entity) {
        this.entity = entity;
    }
}
