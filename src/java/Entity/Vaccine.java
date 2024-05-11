package Entity;

public class Vaccine extends BaseEntity {
    private String type;

    public Vaccine() {
        
    }
 public Vaccine(String type, int id, String name) {
        super(id, name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "type=" + type + '}';
    }
    
}
