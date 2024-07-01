package Controller;

import DAO.AdminDAO;
import Entity.Admin;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class AdminController extends BaseController<Admin> {

    private AdminDAO adminDao;
    private Admin admin;
    private List<Admin> adminList;

    public AdminDAO getAdminDao() {
        if (this.adminDao == null) {
            this.adminDao = new AdminDAO();
        }
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
        this.adminList = this.getAdminDao().getEntities();
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    public AdminController() {

    }

    @Override
    public void AddEntity(Admin doctor) {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.Create(admin);

    }

    @Override
    public Admin GetEntityById(int id) {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.getById(id);
        return null;
    }

    @Override
    public List<Admin> GetEntityList() {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.getEntities();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Admin doctor) {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.Update(doctor);
    }

    @Override
    public void DeleteEntity() {
        if (adminDao == null) {
            adminDao = new AdminDAO();
        }
        adminDao.Delete(admin);
    }

}
