package Entity;

public class Pharmacy extends BaseEntity {
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
        return "Pharmacy{" + "location=" + location + '}';
    }
    
    
}
