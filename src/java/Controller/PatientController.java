package Controller;

import DAO.PatientDAO;
import Entity.Patient;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public class PatientController extends BaseController<Patient> implements Serializable {

    private PatientDAO patientDao;
    private Patient patient;
    private List<Patient> patientList;

    public PatientController(Class<Patient> entityClass) {
        super(entityClass);
    }

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

 
    @Override
    public void AddEntity(Patient patient) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.Create(patient);
    }

    @Override
    public Patient GetEntityById(int id) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.GetById(id);
        return null;
    }

    @Override
    public List<Patient> GetEntityList() {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.GetList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Patient patient) {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.Update(patient);
    }

    @Override
    public void DeleteEntity() {
        if (patientDao == null) {
            patientDao = new PatientDAO();
        }
        patientDao.Delete(patient);
    }

    @Override
    public void AddEntity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateEntity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
