package DAO;

import Entity.TestResult;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TestResultDAO extends BaseDAO<TestResult> {

    public TestResultDAO() {
        super();
    }

    public void createTestResult(TestResult testResult) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(testResult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TestResult> getTestResultList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<TestResult> query = entityManager.createQuery("SELECT tr FROM TestResult tr ORDER BY tr.id ASC", TestResult.class);
        List<TestResult> testResultList = query.getResultList();
        return testResultList;
    }

    public void updateTestResult(TestResult testResult) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(testResult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTestResult(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        TestResult testResult = entityManager.find(TestResult.class, id);
        if (testResult != null) {
            try {
                transaction.begin();
                entityManager.remove(testResult);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public TestResult getTestResultById(int id) {
        EntityManager entityManager = getEntityManager();
        TestResult testResult = entityManager.find(TestResult.class, id);
        return testResult;
    }
}
