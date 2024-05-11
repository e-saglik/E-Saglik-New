package Entity;

import java.util.List;

public class Doctor extends User {

    private String specialization;
    private String hospital;
    private String prescription;
    private String appointment;
    private List<Integer> patientList;

    public Doctor() {

    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, List<Integer> patientList, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
        this.patientList = patientList;
    }

    public Doctor(String specialization, String hospital, String prescription, String appointment, String firstName, String lastName, String email, String password, String gender, String phoneNumber, String address, int id, String name) {
        super(firstName, lastName, email, password, gender, phoneNumber, address, id, name);
        this.specialization = specialization;
        this.hospital = hospital;
        this.prescription = prescription;
        this.appointment = appointment;
    }

    void prescribeMedication() {

    }

    void requestTest() {

    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public List<Integer> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Integer> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String toString() {
        return "Doctor{" + "specialization=" + specialization + ", hospital=" + hospital + ", prescription=" + prescription + ", appointment=" + appointment + ", patientList=" + patientList + '}';

    }

}
