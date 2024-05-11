package Entity;

public class Disease extends BaseEntity {
    
    private String description;

    public Disease() {
    
    }

    public Disease(String description, int id, String name) {
        super(id, name);
        this.description = description;
    }  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Disease{" + "description=" + description + '}';
    }
    
    
    
}
