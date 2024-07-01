package DAO;

import Entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PatientDAO extends AbstractDAO<Patient> {

    public PatientDAO() {
        super();
    }

    public void CreatePatient(Patient patient) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Patient> getPatientList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Patient> query = entityManager.createQuery("SELECT p FROM Patient p ORDER BY p.id ASC", Patient.class);
        return query.getResultList();
    }

    public void UpdatePatient(Patient patient) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeletePatient(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Patient patient = entityManager.find(Patient.class, id);
        if (patient != null) {
            try {
                transaction.begin();
                entityManager.remove(patient);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Patient getPatientById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Patient.class, id);
    }
}
