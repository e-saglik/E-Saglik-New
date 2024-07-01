package Controller;

import DAO.AbstractDAO;
import DAO.MedicationDAO;
import Entity.Medication;
import java.util.List;

public class MedicationController extends BaseController<Medication> {

    private MedicationDAO medicationDao;
    private Medication medication;
    private List<Medication> medicationList;

    public MedicationController() {

    }

    public MedicationDAO getMedicationDao() {
        return medicationDao;
    }

    public void setMedicationDao(MedicationDAO medicationDao) {
        this.medicationDao = medicationDao;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    @Override
    public void AddEntity(Medication medication) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.CreateMedication(medication);

    }

    @Override
    public Medication GetEntityById(int id) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.getMedicationById(id);
        return null;
    }

    @Override
    public List<Medication> GetEntityList() {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.getMedicationList();
        return null;
    }

    @Override
    public void UpdateEntity(int id, Medication medication) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.UpdateMedication(medication);
    }

    @Override
    public void DeleteEntity(int id) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.DeleteMedication(id);
    }

}
