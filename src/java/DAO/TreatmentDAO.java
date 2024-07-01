package DAO;

import Entity.Treatment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TreatmentDAO extends AbstractDAO<Treatment> {

    public TreatmentDAO() {
        super();
    }

    public void CreateTreatment(Treatment treatment) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(treatment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Treatment> getTreatmentList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Treatment> query = entityManager.createQuery("SELECT t FROM Treatment t ORDER BY t.id ASC", Treatment.class);
        List<Treatment> treatmentList = query.getResultList();
        return treatmentList;
    }

    public void UpdateTreatment(Treatment treatment) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(treatment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteTreatment(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Treatment treatment = entityManager.find(Treatment.class, id);
        if (treatment != null) {
            try {
                transaction.begin();
                entityManager.remove(treatment);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Treatment getTreatmentById(int id) {
        EntityManager entityManager = getEntityManager();
        Treatment treatment = entityManager.find(Treatment.class, id);
        return treatment;
    }
}
