package Controller;

import DAO.PatientDAO;
import Entity.Patient;
import java.util.List;

public class PatientController extends BaseController<Patient> {

    private PatientDAO patientDao;
    private Patient patient;
    private List<Patient> patientList;

    public PatientDAO getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public PatientController() {

    }

    @Override
    public void AddEntity(Patient patient) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.CreatePatient(patient);
    }

    @Override
    public Patient GetEntityById(int id) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.getPatientById(id);
        return null;
    }

    @Override
    public List<Patient> GetEntityList() {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.getPatientList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Patient patient) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.UpdatePatient(patient);
    }

    @Override
    public void DeleteEntity(int id) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.DeletePatient(id);
    }
}
