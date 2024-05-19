package Controller;

import DAO.BaseDAO;
import DAO.DonationDAO;
import Entity.Donation;
import java.util.List;

public class DonationController extends BaseController<Donation> {

    private DonationDAO donationDao;
    private Donation donation;
    private List<Donation> donationList;

    public DonationController() {

    }

    public BaseDAO getDonationDao() {
        return donationDao;
    }

    public void setDonationDao(DonationDAO donationDao) {
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
    public void AddEntity(Donation donation) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.CreateDonation(donation);

    }

    @Override
    public Donation GetEntityById(int id) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.GetDonationById(id);
        return null;
    }

    @Override
    public List<Donation> GetEntityList() {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.GetDonationList();

        return null;
    }

    @Override
    public void UpdateEntity(int id, Donation donation) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.UpdateDonation(donation);
    }

    @Override
    public void DeleteEntity(int id) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.DeleteDonation(id);
    }
    
}
