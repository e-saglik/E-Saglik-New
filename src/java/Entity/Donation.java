package Entity;

import java.util.Date;

public class Donation extends BaseEntity {
    private String donationType;
    private String donorName;
    private Date donationDate;

    public Donation() {
    
    }

    public Donation(String donationType, String donorName, Date donationDate, int id, String name) {
        super(id, name);
        this.donationType = donationType;
        this.donorName = donorName;
        this.donationDate = donationDate;
    }

   

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public String toString() {
        return "Donation{" + "donationType=" + donationType + ", donorName=" + donorName + ", donationDate=" + donationDate + '}';
    }
    
    
    
}
