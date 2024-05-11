package Entity;

import java.util.Date;

public class VaccinationSchedule extends BaseEntity {
    private Vaccine vaccineName;
    private Date dueDate;

    public VaccinationSchedule() {
        
    }

    public VaccinationSchedule(Vaccine vaccineName, Date dueDate, int id, String name) {
        super(id, name);
        this.vaccineName = vaccineName;
        this.dueDate = dueDate;
    }

    

    public Vaccine getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(Vaccine vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "VaccinationSchedule{" + "vaccineName=" + vaccineName + ", dueDate=" + dueDate + '}';
    }
    
    
}
