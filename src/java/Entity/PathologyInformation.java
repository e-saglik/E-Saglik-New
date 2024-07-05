package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pathologyinformation")
@NamedQuery(name = "PathologyInformation.findAll", query = "SELECT p FROM PathologyInformation p")
public class PathologyInformation extends BaseEntity implements Serializable {
    @Column(name = "information_date")
    private Date informationDate;

    @Column(name = "information")
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
        return "PathologyInformation{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", informationDate=" + informationDate +
                ", information='" + information + '\'' +
                '}';
    }
}
