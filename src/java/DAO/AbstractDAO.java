package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractDAO<T> {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public AbstractDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
