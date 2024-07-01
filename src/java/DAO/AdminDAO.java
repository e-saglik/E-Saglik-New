package DAO;

import Entity.Admin;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdminDAO extends AbstractDAO<Admin> {

    public AdminDAO() {
        super();
    }

    public void CreateAdmin(Admin admin) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(admin);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Admin> getAdminList() {
        TypedQuery<Admin> query = entityManager.createQuery("SELECT a FROM Admin a ORDER BY a.id ASC", Admin.class);
        return query.getResultList();
    }

    public void UpdateAdmin(Admin admin) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(admin);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteAdmin(int id) {
        try {
            entityManager.getTransaction().begin();
            Admin admin = entityManager.find(Admin.class, id);
            if (admin != null) {
                entityManager.remove(admin);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Admin getAdminById(int id) {
        return entityManager.find(Admin.class, id);
    }
}
