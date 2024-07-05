package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "radiographs")
@NamedQuery(name = "radiographs.findAll", query = "SELECT r FROM radiographs r")
public class Radiograph extends BaseEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name = "rg_date")
    private Date RGDate;

    @Column(name = "image")
    private String image;

    public Radiograph() {
    }

    public Radiograph(Date RGDate, String image, int id, String name) {
        super(id, name);
        this.RGDate = RGDate;
        this.image = image;
    }

    public Date getRGDate() {
        return RGDate;
    }

    public void setRGDate(Date RGDate) {
        this.RGDate = RGDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Radiograph{" + "RGDate=" + RGDate + ", image=" + image + '}';
    }
}
