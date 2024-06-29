package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pharmacy")
public class Pharmacy extends BaseEntity {
    @Column(name = "location")
    private String location;

    public Pharmacy() {
        
    }

    public Pharmacy(String location, int id, String name) {
        super(id, name);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
