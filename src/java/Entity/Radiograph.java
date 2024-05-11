package Entity;

import java.util.Date;

public class Radiograph extends BaseEntity {
    private Date RGDate;
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
