package Controller;

import DAO.AbstractDAO;
import DAO.MedicationDAO;
import Entity.Medication;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MedicationController extends BaseController<Medication> implements Serializable{
    
    @EJB
    private MedicationDAO medicationDao;
    private Medication medication;
    private List<Medication> medicationList;

    public MedicationController() {
        super(Medication.class);
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
    public void AddEntity() {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.Create(medication);

    }

    @Override
    public Medication GetEntityById(int id) {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.GetById(id);
        return null;
    }

    @Override
    public List<Medication> GetEntityList() {
        return getMedicationDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.Update(medication);
    }

    @Override
    public void DeleteEntity() {
        if (medicationDao == null) {
            medicationDao = new MedicationDAO();
        }
        medicationDao.Delete(medication);
    }

}
