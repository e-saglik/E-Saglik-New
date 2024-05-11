
package Entity;

public class Hospital extends BaseEntity {
    private String location;
    private String capacity;

    public Hospital() {
    
    }

    public Hospital(String location, String capacity, int id, String name) {
        super(id, name);
        this.location = location;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" + "location=" + location + ", capacity=" + capacity + '}';
    }
    
    
}
