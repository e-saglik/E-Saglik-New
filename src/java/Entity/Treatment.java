package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "treatments")
@NamedQuery(name = "Treatments.findAll", query = "SELECT t FROM Treatments t")
public class Treatment extends BaseEntity implements Serializable {
    
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;


    public Treatment() {
    }

    public Treatment(Date startdate, Date endDate, String description, int id, String name) {
        super(id, name);
        this.startdate = startdate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Treatment{" + "startdate=" + startdate + ", endDate=" + endDate + ", description=" + description + '}';
    }
}
