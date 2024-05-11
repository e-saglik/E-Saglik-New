package Entity;

import java.util.Date;

public class Treatment extends BaseEntity {
    private Date startdate;
    private Date endDate;
    private String description;

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
