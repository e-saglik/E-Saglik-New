package Controller;

import DAO.BaseDAO;
import Entity.Donation;
import java.util.List;

public class DonationController extends BaseController<Donation> {

    private BaseDAO donationDao;
    private Donation donation;
    private List<Donation> donationList;

    public DonationController() {

    }

    public BaseDAO getDonationDao() {
        return donationDao;
    }

    public void setDonationDao(BaseDAO donationDao) {
        this.donationDao = donationDao;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public List<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    @Override
    public void AddEntity(Donation doctor) {
        if (donationDao == null) {
            //donationDao = new DonationDAO();
        }
        //donationDao.CreateDonation(doctor);

    }

    @Override
    public Donation GetEntityById(int id) {
        if (donationDao == null) {
            //donationDao = new DonationDAO();
        }
        //donationDao.GetDonationById(id);
        return null;
    }

    @Override
    public List<Donation> GetEntityList() {
        if (donationDao == null) {
            //donationDao = new DonationDAO();
        }
        //donationDao.GetDonationList();

        return null;
    }

    @Override
    public void UpdateEntity(int id, Donation doctor) {
        if (donationDao == null) {
            //donationDao = new DonationDAO();
        }
        //donationDao.UpdateDonation(doctor);
    }

    @Override
    public void DeleteEntity(int id) {
        if (donationDao == null) {
            //donationDao = new DonationDAO();
        }
        //donationDao.DeleteDonation(id);
    }
    
}
