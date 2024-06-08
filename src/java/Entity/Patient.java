
package Entity;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date dateOfBirth;
    private String bloodType;
    private String appointment;
    private List<Medication> medicationList;
    private List<MedicalReport>  medicalReportList;
    private List<TestResult>  testResultList;
    private List<Disease>  diseaseList;
    private List<Allergy>  allergyList;
    private String insurance;
    private String vaccinationSchedule;
    private List<Treatment>  treatmentList;
    private List<Payment>  paymentList;
    private List<Notification>  notificationList;

    public Patient() {
    }

    public Patient(Date dateOfBirth, String bloodType, String appointment, List<Medication> medicationList, List<MedicalReport> medicalReportList, List<TestResult> testResultList, List<Disease> diseaseList, List<Allergy> allergyList, String insurance, String vaccinationSchedule, List<Treatment> treatmentList, List<Payment> paymentList, List<Notification> notificationList, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
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
 
    
    void makeAppointment(){
        
    }
    
    void viewMedicalReport(){
        
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

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String ınsurance) {
        this.insurance = ınsurance;
    }

    public String getVaccinationSchedule() {
        return vaccinationSchedule;
    }

    public void setVaccinationSchedule(String vaccinationSchedule) {
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

    @Override
    public String toString() {
        return "Patient{" + "dateOfBirth=" + dateOfBirth + ", bloodType=" + bloodType + ", appointment=" + appointment + ", medicationList=" + medicationList + ", medicalReportList=" + medicalReportList + ", testResultList=" + testResultList + ", diseaseList=" + diseaseList + ", allergyList=" + allergyList + ", insurance=" + insurance + ", vaccinationSchedule=" + vaccinationSchedule + ", treatmentList=" + treatmentList + ", paymentList=" + paymentList + ", notificationList=" + notificationList + '}';
    }
    
    
}
