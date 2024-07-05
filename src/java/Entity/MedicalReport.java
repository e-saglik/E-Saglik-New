package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medicalreport")
@NamedQuery(name = "MedicalReport.findAll", query = "SELECT m FROM MedicalReport m")
public class MedicalReport extends BaseEntity implements Serializable {

    @Column(name = "medical_report_date")
    private Date medicalReportDate;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalReport() {

    }

    public MedicalReport(Date medicalReportDate, String diagnosis, String description, Patient patient, int id, String name) {
        super(id, name);
        this.medicalReportDate = medicalReportDate;
        this.diagnosis = diagnosis;
        this.description = description;
        this.patient = patient;
    }

    public Date getMedicalReportDate() {
        return medicalReportDate;
    }

    public void setMedicalReportDate(Date medicalReportDate) {
        this.medicalReportDate = medicalReportDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedicalReport{"
                + "id=" + getId()
                + ", name='" + getName() + '\''
                + ", medicalReportDate=" + medicalReportDate
                + ", diagnosis='" + diagnosis + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
