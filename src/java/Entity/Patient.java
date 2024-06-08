
package Entity;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date dateOfBirth;
    private String bloodType;
    private String appointment;
    private List<Patient> medicationList;
    private List<Patient>  medicalReportList;
    private List<Patient>  testResultList;
    private List<Patient>  diseaseList;
    private List<Patient>  allergyList;
    private String insurance;
    private String vaccinationSchedule;
    private List<Patient>  treatmentList;
    private List<Patient>  paymentList;
    private List<Patient>  notificationList;

    public Patient() {
    }

    public Patient(Date dateOfBirth, String bloodType, String appointment, List<Patient> medicationList, List<Patient> medicalReportList, List<Patient> testResultList, List<Patient> diseaseList, List<Patient> allergyList, String insurance, String vaccinationSchedule, List<Patient> treatmentList, List<Patient> paymentList, List<Patient> notificationList, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
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

    public List<Patient> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Patient> medicationList) {
        this.medicationList = medicationList;
    }

    public List<Patient> getMedicalReportList() {
        return medicalReportList;
    }

    public void setMedicalReportList(List<Patient> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    public List<Patient> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<Patient> testResultList) {
        this.testResultList = testResultList;
    }

    public List<Patient> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Patient> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public List<Patient> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Patient> allergyList) {
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

    public List<Patient> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Patient> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public List<Patient> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Patient> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Patient> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Patient> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public String toString() {
        return "Patient{" + "dateOfBirth=" + dateOfBirth + ", bloodType=" + bloodType + ", appointment=" + appointment + ", medicationList=" + medicationList + ", medicalReportList=" + medicalReportList + ", testResultList=" + testResultList + ", diseaseList=" + diseaseList + ", allergyList=" + allergyList + ", insurance=" + insurance + ", vaccinationSchedule=" + vaccinationSchedule + ", treatmentList=" + treatmentList + ", paymentList=" + paymentList + ", notificationList=" + notificationList + '}';
    }
    
    
}
