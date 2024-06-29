package DAO;

import Entity.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PaymentDAO extends BaseDAO<Payment> {

    public PaymentDAO() {
        super();
    }

    public void createPayment(Payment payment) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Payment> getPaymentList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p ORDER BY p.id ASC", Payment.class);
        return query.getResultList();
    }

    public void updatePayment(Payment payment) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePayment(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Payment payment = entityManager.find(Payment.class, id);
        if (payment != null) {
            try {
                transaction.begin();
                entityManager.remove(payment);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Payment getPaymentById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Payment.class, id);
    }
}
