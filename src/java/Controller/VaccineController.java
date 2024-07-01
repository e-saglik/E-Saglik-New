package Controller;

import DAO.AbstractDAO;
import DAO.VaccineDAO;
import Entity.Vaccine;
import java.util.List;

public class VaccineController extends BaseController<Vaccine> {

    private VaccineDAO donationDao;
    private Vaccine vaccine;
    private List<Vaccine> vaccineList;

    public AbstractDAO getDonationDao() {
        return donationDao;
    }

    public void setDonationDao(VaccineDAO donationDao) {
        this.donationDao = donationDao;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    public VaccineController() {

    }


    @Override
    public Vaccine GetEntityById(int id) {
        if (donationDao == null) {
            donationDao = new VaccineDAO();
        }
        donationDao.getById(id);
        return null;
    }

    @Override
    public List<Vaccine> GetEntityList() {
        if (donationDao == null) {
            donationDao = new VaccineDAO();
        }
        donationDao.getEntities();

        return donationDao.getEntities();
    }

    @Override
    public void UpdateEntity(int id, Vaccine vaccine) {
        if (donationDao == null) {
            donationDao = new VaccineDAO();
        }
        donationDao.Update(vaccine);
    }

    @Override
    public void DeleteEntity() {
        if (donationDao == null) {
            donationDao = new VaccineDAO();
        }
        donationDao.Delete(vaccine);
    }

    @Override
    public void AddEntity(Vaccine entity) {
        if (donationDao == null) {
            donationDao = new VaccineDAO();
        }
        donationDao.Create(vaccine);
    }

}
