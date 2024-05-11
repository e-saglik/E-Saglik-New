package Entity;
    
import java.util.Date;

public class MedicalReport extends BaseEntity {
    private Date medicalReportDate;
    private String diagnosis;
    private String description;

    public MedicalReport() {
    
    }

    public MedicalReport(Date medicalReportDate, String diagnosis, String description, int id, String name) {
        super(id, name);
        this.medicalReportDate = medicalReportDate;
        this.diagnosis = diagnosis;
        this.description = description;
    }

    
    private void addTestResult(){
        
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
        return "MedicalReport{" + "medicalReportDate=" + medicalReportDate + ", diagnosis=" + diagnosis + ", description=" + description + '}';
    }
    
    
}
