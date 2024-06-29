package DAO;

import Entity.PolyClinic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PolyClinicDAO extends AbstractDAO<PolyClinic> {

    public PolyClinicDAO() {
        super();
    }

    public PolyClinic getPolyClinicById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(PolyClinic.class, id);
    }

    public void CreatePolyClinic(PolyClinic polyClinic) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(polyClinic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void UpdatePolyClinic(PolyClinic polyClinic) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(polyClinic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeletePolyClinic(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        PolyClinic polyClinic = entityManager.find(PolyClinic.class, id);
        if (polyClinic != null) {
            try {
                transaction.begin();
                entityManager.remove(polyClinic);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }
}
