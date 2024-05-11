package Entity;

import java.util.Date;

public class PathologyInformation extends BaseEntity {
    private Date informationDate;
    private String information;

    public PathologyInformation() {
    
    }

    public PathologyInformation(Date informationDate, String information, int id, String name) {
        super(id, name);
        this.informationDate = informationDate;
        this.information = information;
    }

    

    public Date getInformationDate() {
        return informationDate;
    }

    public void setInformationDate(Date informationDate) {
        this.informationDate = informationDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "PathologyInformation{" + "informationDate=" + informationDate + ", information=" + information + '}';
    }
    
    
    
}
