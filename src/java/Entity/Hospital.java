
package Entity;

import java.util.List;

public class Hospital extends BaseEntity {
    private String location;
    private String capacity;
    private List<PolyClinic> polyClinics;
    private List<Doctor> doctors;

    public Hospital() {
    
    }

    public Hospital(String location, String capacity, List<PolyClinic> polyClinics, List<Doctor> doctors, int id, String name) {
        super(id, name);
        this.location = location;
        this.capacity = capacity;
        this.polyClinics = polyClinics;
        this.doctors = doctors;
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

    public List<PolyClinic> getPolyClinics() {
        return polyClinics;
    }

    public void setPolyClinics(List<PolyClinic> polyClinics) {
        this.polyClinics = polyClinics;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    } 

    @Override
    public String toString() {
        return "Hospital{" + "location=" + location + ", capacity=" + capacity + '}';
    }
    
    
}
