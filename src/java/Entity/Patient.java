
package Entity;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date dateOfBirth;
    private String bloodType;
    private String appointment;
    private List<Integer> medicationList;
    private List<Integer>  medicalReportList;
    private List<Integer>  testResultList;
    private List<Integer>  diseaseList;
    private List<Integer>  allergyList;
    private String insurance;
    private String vaccinationSchedule;
    private List<String>  treatmentList;
    private List<String>  paymentList;
    private List<String>  notificationList;

    public Patient() {
    }

    public Patient(Date dateOfBirth, String bloodType, String appointment, List<Integer> medicationList, List<Integer> medicalReportList, List<Integer> testResultList, List<Integer> diseaseList, List<Integer> allergyList, String insurance, String vaccinationSchedule, List<String> treatmentList, List<String> paymentList, List<String> notificationList, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
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

    public List<Integer> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Integer> medicationList) {
        this.medicationList = medicationList;
    }

    public List<Integer> getMedicalReportList() {
        return medicalReportList;
    }

    public void setMedicalReportList(List<Integer> medicalReportList) {
        this.medicalReportList = medicalReportList;
    }

    public List<Integer> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<Integer> testResultList) {
        this.testResultList = testResultList;
    }

    public List<Integer> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Integer> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public List<Integer> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Integer> allergyList) {
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

    public List<String> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<String> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public List<String> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<String> paymentList) {
        this.paymentList = paymentList;
    }

    public List<String> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<String> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public String toString() {
        return "Patient{" + "dateOfBirth=" + dateOfBirth + ", bloodType=" + bloodType + ", appointment=" + appointment + ", medicationList=" + medicationList + ", medicalReportList=" + medicalReportList + ", testResultList=" + testResultList + ", diseaseList=" + diseaseList + ", allergyList=" + allergyList + ", insurance=" + insurance + ", vaccinationSchedule=" + vaccinationSchedule + ", treatmentList=" + treatmentList + ", paymentList=" + paymentList + ", notificationList=" + notificationList + '}';
    }
    
    
}
