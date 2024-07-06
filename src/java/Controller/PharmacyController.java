package Controller;

import DAO.AbstractDAO;
import DAO.PharmacyDAO;
import Entity.Pharmacy;
import java.util.List;

public class PharmacyController extends BaseController<Pharmacy> {

    private PharmacyDAO pharmacyDao;
    private Pharmacy pharmacy;
    private List<Pharmacy> pharmacyList;

    public PharmacyController() {
        super(Pharmacy.class);
    }

    public PharmacyDAO getPharmacyDao() {
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

    @Override
    public Pharmacy GetEntityById(int id) {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.GetById(id);
        return null;
    }

    @Override
    public List<Pharmacy> GetEntityList() {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.GetList();

        return pharmacyDao.GetList();
    }

    @Override
    public void UpdateEntity() {
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
    public void AddEntity() {
        if (pharmacyDao == null) {
            pharmacyDao = new PharmacyDAO();
        }
        pharmacyDao.Create(pharmacy);
    }
}
