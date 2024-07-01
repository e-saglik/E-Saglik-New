package DAO;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public abstract class AbstractDAO<T> implements Serializable {

    @PersistenceContext(unitName = "E-SaglikPU")
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> entityClass;

    public AbstractDAO() {
    }

    public AbstractDAO(Class<T> ec) {
        this.entityClass = ec;
    }

    public void Create(T entity) {
        entityManager.persist(entity);
    }

    public void Update(T entity) {
        entityManager.merge(entity);
    }

    public List<T> getEntities() {
        Query q = entityManager.createQuery("select c from " + entityClass.getSimpleName() + " c order by c.id desc", entityClass);
        return q.getResultList();
    }

    public void Delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
        entityManager.flush();
    }

    public T getById(Long id) {
        return (T) entityManager.find(entityClass, id);
    }

    public List<T> findRange(int[] range) {
        jakarta.persistence.Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int Count() {
        jakarta.persistence.Query q = entityManager.createQuery("SELECT COUNT(e) FROM " + entityClass.getName() + " e");
        return ((Long) q.getSingleResult()).intValue();
    }
}
