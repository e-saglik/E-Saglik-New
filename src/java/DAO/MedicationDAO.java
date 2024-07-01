package DAO;

import Entity.Medication;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class MedicationDAO extends AbstractDAO<Medication> {

    public MedicationDAO() {
        super();
    }

    public void CreateMedication(Medication medication) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(medication);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Medication> getMedicationList() {
        TypedQuery<Medication> query = getEntityManager().createQuery("SELECT m FROM Medication m ORDER BY m.id ASC", Medication.class);
        List<Medication> medicationList = query.getResultList();
        return medicationList;
    }

    public void UpdateMedication(Medication medication) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(medication);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteMedication(int id) {
        Medication medication = getEntityManager().find(Medication.class, id);
        if (medication != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(medication);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Medication getMedicationById(int id) {
        Medication medication = getEntityManager().find(Medication.class, id);
        return medication;
    }
}
