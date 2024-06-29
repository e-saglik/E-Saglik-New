package DAO;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Local
@Stateless
public abstract class AbstractDAO<T> {

    
    @PersistenceContext(unitName = "E-SaglikDB")
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Class<T> entityClass;

    public AbstractDAO() {
	}
    
    public AbstractDAO(Class<T> ec) {
		this.entityClass = ec;
	}
    
    public void create(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public List<T> getEntities() {
		Query q = entityManager.createQuery("select c from " + entityClass.getSimpleName() + " c order by c.id desc", entityClass);
		return q.getResultList();
	}

	public void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
		entityManager.flush();
	}

	public T getById(Long id) {
		return (T) entityManager.find(entityClass, id);
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
