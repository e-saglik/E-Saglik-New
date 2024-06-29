package DAO;

import Entity.Prescription;
import Entity.Medication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PrescriptionDAO extends BaseDAO<Prescription> {

    public PrescriptionDAO() {
        super();
    }

    public void CreatePrescription(Prescription prescription) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(prescription);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Prescription> getPrescriptionList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Prescription> query = entityManager.createQuery("SELECT p FROM Prescription p ORDER BY p.id ASC", Prescription.class);
        List<Prescription> prescriptionList = query.getResultList();
        return prescriptionList;
    }

    public void UpdatePrescription(Prescription prescription) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(prescription);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeletePrescription(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Prescription prescription = entityManager.find(Prescription.class, id);
        if (prescription != null) {
            try {
                transaction.begin();
                entityManager.remove(prescription);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Prescription getPrescriptionById(int id) {
        EntityManager entityManager = getEntityManager();
        Prescription prescription = entityManager.find(Prescription.class, id);
        return prescription;
    }
}
