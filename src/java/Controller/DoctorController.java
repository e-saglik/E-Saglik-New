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
    private int page=1;
    private int pageSize=10;
    private int pageCount;
    
    public void next(){
        if(this.page == getPageCount()){
            this.page=1;
        }
        else{
            this.page++;    
        }
        
    }

    public void previous(){
        if(this.page == 1){
            this.page=this.getPageCount();
        }
        else{
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
        this.pageCount = (int) Math.ceil(getDao().Count()/(double)pageSize);
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
        this.getDao().Update(this.entity);
        this.entity = new Doctor();  
    }

    public void create() {
        this.getDao().Create(this.entity);
        this.entity = new Doctor();
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
        this.list = this.getDao().GetList(page,pageSize);
        return list;
    }

    public void setList(List<Doctor> list) {
        this.list = list;
    }

    public DoctorController() {

    }

    @Override
    public void AddEntity(Doctor entity) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.Create(entity);

    }

    @Override
    public Doctor GetEntityById(int id) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.GetById(id);
        return null;
    }

    @Override
    public List<Doctor> GetEntityList() {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.GetList(page,pageSize);

        return dao.GetList(page,pageSize);
    }

    @Override
    public void UpdateEntity(int id, Doctor entity) {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.Update(entity);
    }

    @Override
    public void DeleteEntity() {
        if (dao == null) {
            dao = new DoctorDAO();
        }
        dao.Delete(entity);
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
