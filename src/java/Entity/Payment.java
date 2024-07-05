package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment extends BaseEntity {
    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "payment_date")
    private Date paymentDate;
    
    @ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;


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
        return "Payment{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
