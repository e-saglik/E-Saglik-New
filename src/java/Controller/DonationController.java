package Controller;

import DAO.DonationDAO;
import Entity.Donation;
import java.util.List;

public class DonationController extends BaseController<Donation> {

    private DonationDAO donationDao;
    private Donation donation;
    private List<Donation> donationList;

    public DonationController() {

    }

    public DonationDAO getDonationDao() {
        if (this.donationDao == null) {
            this.donationDao = new DonationDAO();
        }
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
        this.donationList = this.getDonationDao().getEntities();
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
        donationDao.Create(donation);

    }

    @Override
    public Donation GetEntityById(int id) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.getById(id);
        return null;
    }

    @Override
    public List<Donation> GetEntityList() {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.getEntities();

        return null;
    }

    @Override
    public void UpdateEntity(int id, Donation donation) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.Update(donation);
    }

    @Override
    public void DeleteEntity() {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.Delete(donation);
    }
    
}
