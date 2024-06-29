package DAO;

import Entity.VaccinationSchedule;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VaccinationScheduleDAO extends BaseDAO<VaccinationSchedule> {

    public VaccinationScheduleDAO() {
        super();
    }

    public void createVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(vaccinationSchedule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<VaccinationSchedule> getVaccinationScheduleList() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<VaccinationSchedule> query = entityManager.createQuery("SELECT vs FROM VaccinationSchedule vs ORDER BY vs.id ASC", VaccinationSchedule.class);
        List<VaccinationSchedule> vaccinationScheduleList = query.getResultList();
        return vaccinationScheduleList;
    }

    public void updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(vaccinationSchedule);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteVaccinationSchedule(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        VaccinationSchedule vaccinationSchedule = entityManager.find(VaccinationSchedule.class, id);
        if (vaccinationSchedule != null) {
            try {
                transaction.begin();
                entityManager.remove(vaccinationSchedule);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public VaccinationSchedule getVaccinationScheduleById(int id) {
        EntityManager entityManager = getEntityManager();
        VaccinationSchedule vaccinationSchedule = entityManager.find(VaccinationSchedule.class, id);
        return vaccinationSchedule;
    }
}
