package Controller;

import DAO.AbstractDAO;
import DAO.PharmacyDAO;
import Entity.Pharmacy;
import java.util.List;

public class PharmacyController extends BaseController<Pharmacy> {

    public AbstractDAO getPharmacyDao() {
        return pharmacyDao;
    }

    public void setPharmacyDao(PharmacyDAO pharmacyDao) {
        this.pharmacyDao = pharmacyDao;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Pharmacy> getPharmacyList() {
        return pharmacyList;
    }

    public void setPharmacyList(List<Pharmacy> pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    private PharmacyDAO pharmacyDao;
    private Pharmacy pharmacy;
    private List<Pharmacy> pharmacyList;

    public PharmacyController() {

    }


   @Override
    public Pharmacy GetEntityById(int id) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.getById(id);
        return null;
    }

    @Override
    public List<Pharmacy> GetEntityList() {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.getEntities();

        return pharmacyDao.getEntities();
    }

    @Override
    public void UpdateEntity(int id, Pharmacy pharmacy) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.Update(pharmacy);
    }

    @Override
    public void DeleteEntity() {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.Delete(pharmacy);
    }

    @Override
    public void AddEntity(Pharmacy entity) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.Create(pharmacy);
    }
}
