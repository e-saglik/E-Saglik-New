package DAO;

import Entity.Radiograph;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RadiographDAO extends BaseDAO<Radiograph> {

    public RadiographDAO() {
        super();
    }

    public void CreateRadiograph(Radiograph radiograph) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(radiograph);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Radiograph> getRadiographList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Radiograph> query = entityManager.createQuery("SELECT r FROM Radiograph r ORDER BY r.id ASC", Radiograph.class);
        List<Radiograph> radiographList = query.getResultList();
        return radiographList;
    }

    public void UpdateRadiograph(Radiograph radiograph) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(radiograph);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteRadiograph(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Radiograph radiograph = entityManager.find(Radiograph.class, id);
        if (radiograph != null) {
            try {
                transaction.begin();
                entityManager.remove(radiograph);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Radiograph getRadiographById(int id) {
        EntityManager entityManager = getEntityManager();
        Radiograph radiograph = entityManager.find(Radiograph.class, id);
        return radiograph;
    }
}
