package Controller;

import DAO.AdminDAO;
import Entity.Admin;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminController extends BaseController<Admin> {

    private AdminDAO adminDao;
    private Admin admin;
    private List<Admin> adminList;

    public AdminDAO getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public AdminController() {

    }

    @Override
    public void AddEntity(Admin admin) {

    }

    @Override
    public Admin GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Admin> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Admin admin) {

    }

    @Override
    public void DeleteEntity(int id) {

    }
}
