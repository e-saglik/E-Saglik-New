package DAO;

import Entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DoctorDAO extends AbstractDAO<Doctor> {

    public DoctorDAO() {
        super();
    }

    public void CreateDoctor(Doctor doctor) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(doctor);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Doctor> getDoctorList(int page, int pageSize) {
        TypedQuery<Doctor> query = getEntityManager().createQuery("SELECT d FROM Doctor d ORDER BY d.id ASC", Doctor.class);
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public long countDoctors() {
        TypedQuery<Long> query = getEntityManager().createQuery("SELECT COUNT(d) FROM Doctor d", Long.class);
        return query.getSingleResult();
    }

    public void UpdateDoctor(Doctor doctor) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(doctor);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeleteDoctor(int id) {
        Doctor doctor = getEntityManager().find(Doctor.class, id);
        if (doctor != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(doctor);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public Doctor getDoctorById(int id) {
        return getEntityManager().find(Doctor.class, id);
    }
}
