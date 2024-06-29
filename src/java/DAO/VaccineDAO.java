package DAO;

import Entity.Vaccine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VaccineDAO extends BaseDAO<Vaccine> {

    public VaccineDAO() {
        super();
    }

    public void CreateVaccine(Vaccine vaccine) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(vaccine);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Vaccine> getVaccineList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Vaccine> query = entityManager.createQuery("SELECT v FROM Vaccine v ORDER BY v.id ASC", Vaccine.class);
        List<Vaccine> vaccineList = query.getResultList();
        return vaccineList;
    }

    public void UpdateVaccine(Vaccine vaccine) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(vaccine);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteVaccine(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Vaccine vaccine = entityManager.find(Vaccine.class, id);
        if (vaccine != null) {
            try {
                transaction.begin();
                entityManager.remove(vaccine);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Vaccine getVaccineById(int id) {
        EntityManager entityManager = getEntityManager();
        Vaccine vaccine = entityManager.find(Vaccine.class, id);
        return vaccine;
    }
}
