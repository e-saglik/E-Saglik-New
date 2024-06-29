package Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Patient")
public class Patient extends User {

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "appointment")
    private String appointment;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Medication> medicationList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalReport> medicalReportList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<TestResult> testResultList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Patient_Disease",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id")
    )
    private List<Disease> diseaseList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Allergy> allergyList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccination_schedule_id")
    private VaccinationSchedule vaccinationSchedule;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Treatment> treatmentList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Notification> notificationList;

    @ManyToMany
    @JoinTable(
            name = "patient_role",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public Patient() {
    }

    public Patient(Date dateOfBirth, String bloodType, String appointment, List<Medication> medicationList, List<MedicalReport> medicalReportList, List<TestResult> testResultList, List<Disease> diseaseList, List<Allergy> allergyList, Insurance insurance, VaccinationSchedule vaccinationSchedule, List<Treatment> treatmentList, List<Payment> paymentList, List<Notification> notificationList, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.appointment = appointment;
        this.medicationList = medicationList;
        this.medicalReportList = medicalReportList;
        this.testResultList = testResultList;
        this.diseaseList = diseaseList;
        this.allergyList = allergyList;
        this.insurance = insurance;
        this.vaccinationSchedule = vaccinationSchedule;
        this.treatmentList = treatmentList;
        this.paymentList = paymentList;
        this.notificationList = notificationList;
    }

    public void makeAppointment() {
        // Implement appointment making logic
    }

    public void viewMedicalReport() {
        // Implement medical report viewing logic
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public List<MedicalReport> getMedicalReportList() {
        return medicalReportList;
    }

    public void setMedicalReportList(List<MedicalReport> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public List<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public VaccinationSchedule getVaccinationSchedule() {
        return vaccinationSchedule;
    }

    public void setVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        this.vaccinationSchedule = vaccinationSchedule;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "dateOfBirth=" + dateOfBirth +
                ", bloodType='" + bloodType + '\'' +
                ", appointment='" + appointment + '\'' +
                ", medicationList=" + medicationList +
                ", medicalReportList=" + medicalReportList +
                ", testResultList=" + testResultList +
                ", diseaseList=" + diseaseList +
                ", allergyList=" + allergyList +
                ", insurance=" + insurance +
                ", vaccinationSchedule=" + vaccinationSchedule +
                ", treatmentList=" + treatmentList +
                ", paymentList=" + paymentList +
                ", notificationList=" + notificationList +
                ", roles=" + roles +
                '}';
    }
}
