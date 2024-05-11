package Entity;

public class Allergy extends BaseEntity {
    private String type;
    private int severity;

    public Allergy() {
        
    }

    public Allergy(String type, int severity, int id, String name) {
        super(id, name);
        this.type = type;
        this.severity = severity;
    } 

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Allergy{" + "type=" + type + ", severity=" + severity + '}';
    }
    
    
    
}
