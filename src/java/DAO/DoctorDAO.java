package DAO;

import Entity.Doctor;
import jakarta.ejb.Local;
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
    public List<Doctor> GetList(){
        List<Doctor> doctors = entityManager.createQuery(
                    "SELECT d FROM Doctor d", Doctor.class)
                    .getResultList();
        
        return doctors;
    }
    
}
