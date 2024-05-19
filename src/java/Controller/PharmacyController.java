package Controller;

import DAO.BaseDAO;
import DAO.PharmacyDAO;
import Entity.Pharmacy;
import java.util.List;

public class PharmacyController extends BaseController<Pharmacy> {

    public BaseDAO getPharmacyDao() {
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
        pharmacyDao.GetPharmacyById(id);
        return null;
    }

    @Override
    public List<Pharmacy> GetEntityList() {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.GetPharmacyList();

        return pharmacyDao.GetPharmacyList();
    }

    @Override
    public void UpdateEntity(int id, Pharmacy pharmacy) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.UpdatePharmacy(pharmacy);
    }

    @Override
    public void DeleteEntity(int id) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.DeletePharmacy(id);
    }
}
