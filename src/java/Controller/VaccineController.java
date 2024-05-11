package Controller;

import DAO.BaseDAO;
import Entity.Vaccine;
import java.util.List;

public class VaccineController extends BaseController<Vaccine> {

    private BaseDAO donationDao;
    private Vaccine vaccine;
    private List<Vaccine> vaccineList;

    public BaseDAO getDonationDao() {
        return donationDao;
    }

    public void setDonationDao(BaseDAO donationDao) {
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
    public void AddEntity(Vaccine vaccine) {

    }

    @Override
    public Vaccine GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Vaccine> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Vaccine vaccine) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
