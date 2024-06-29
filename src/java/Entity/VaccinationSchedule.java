package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "vaccination_schedules")
public class VaccinationSchedule extends BaseEntity {

    @ManyToOne
    private Vaccine vaccineName;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
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
