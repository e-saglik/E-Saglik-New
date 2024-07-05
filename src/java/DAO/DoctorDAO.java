package DAO;

import Entity.Doctor;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Stateless
public class DoctorDAO extends AbstractDAO<Doctor> implements Serializable {

    public DoctorDAO() {
        super(Doctor.class);
    }
    
    @Override
    public List<Doctor> GetList() {
        TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM doctor d ORDER BY d.id DESC", Doctor.class);
        List<Doctor> doctors = query.getResultList();
        return doctors;
    }
    
}
