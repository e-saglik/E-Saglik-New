package Entity;

import java.util.Date;

public class Payment extends BaseEntity {
    private double paymentAmount;
    private Date paymentDate;

    public Payment() {
        
    }

    public Payment(double paymentAmount, Date paymentDate, int id, String name) {
        super(id, name);
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
    }

    

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate + '}';
    }
    
    
}
