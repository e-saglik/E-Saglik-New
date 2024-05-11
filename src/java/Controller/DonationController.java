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
    public void AddEntity(Donation donation) {

    }

    @Override
    public Donation GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Donation> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

//    public void AddUser(User user){
//        
//    }
//    
//    public User GetUserById(int id){      
//        return null;        
//    }
//    
//    public List<User> GetUserList(){ 
//        return null;
//    }
//    
//    public void UpdateUser(int id,User user){
//        
//    }
//    
//    public void DeleteUser(int id){
//        
//    }
}
