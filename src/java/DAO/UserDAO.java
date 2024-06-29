package DAO;

import Entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    public UserDAO() {
        super();
    }

    public void CreateUser(User user) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getUserList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u ORDER BY u.id ASC", User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    public void UpdateUser(User user) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteUser(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User user = entityManager.find(User.class, id);
        if (user != null) {
            try {
                transaction.begin();
                entityManager.remove(user);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        EntityManager entityManager = getEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }
}
