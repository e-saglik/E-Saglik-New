package DAO;

import Entity.Insurance;
import Entity.Patient;

import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class InsuranceDAO extends AbstractDAO<Insurance> {

    public InsuranceDAO() {
        super();
    }

    public void CreateInsurance(Insurance insurance) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(insurance);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Insurance> getInsuranceList() {
        TypedQuery<Insurance> query = getEntityManager().createQuery("SELECT i FROM Insurance i ORDER BY i.id ASC", Insurance.class);
        List<Insurance> insuranceList = query.getResultList();
        return insuranceList;
    }

    public void UpdateInsurance(Insurance insurance) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(insurance);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteInsurance(int id) {
        Insurance insurance = getEntityManager().find(Insurance.class, id);
        if (insurance != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(insurance);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Insurance getInsuranceById(int id) {
        Insurance insurance = getEntityManager().find(Insurance.class, id);
        return insurance;
    }
}
