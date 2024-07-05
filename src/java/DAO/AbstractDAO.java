package DAO;

import Entity.Doctor;
import Entity.User;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public abstract class AbstractDAO<T> implements Serializable {

    
    @PersistenceContext(unitName = "E-SaglikPU")
    protected EntityManager entityManager;
    protected Class<T> entityClass;

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

    public List<T> GetList() {
        String jpql = "SELECT u, d FROM User u LEFT JOIN u.doctor d";
    TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
    List<Object[]> results = query.getResultList();

    List<User> users = new ArrayList<>();
    for (Object[] result : results) {
        User user = (User) result[0];
        Doctor doctor = (Doctor) result[1];
        user.setDoctor(doctor); // Assuming there's a method to set the doctor in User entity
        users.add(user);
    }

    return (List<T>) users;
    }

    public void Delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
        entityManager.flush();
    }

    public T GetById(int id) {
//        return (T) entityManager.find(entityClass, id);
return null;
    }

    public List<T> FindRange(int[] range) {
        Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int Count() {
        Query q = entityManager.createQuery("SELECT COUNT(e) FROM " + entityClass.getName() + " e");
        return ((Long) q.getSingleResult()).intValue();
    }
}
