package DAO;

import Entity.Pharmacy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PharmacyDAO extends AbstractDAO<Pharmacy> {

    public PharmacyDAO() {
        super();
    }

    public void CreatePharmacy(Pharmacy pharmacy) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(pharmacy);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Pharmacy> getPharmacyList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Pharmacy> query = entityManager.createQuery("SELECT p FROM Pharmacy p ORDER BY p.id ASC", Pharmacy.class);
        return query.getResultList();
    }

    public void UpdatePharmacy(Pharmacy pharmacy) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(pharmacy);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeletePharmacy(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Pharmacy pharmacy = entityManager.find(Pharmacy.class, id);
        if (pharmacy != null) {
            try {
                transaction.begin();
                entityManager.remove(pharmacy);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Pharmacy getPharmacyById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Pharmacy.class, id);
    }
}
