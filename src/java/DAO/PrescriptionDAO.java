package DAO;

import Entity.Prescription;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PrescriptionDAO extends AbstractDAO<Prescription> implements Serializable {

    public PrescriptionDAO() {
        super(Prescription.class);
    }
    
    @Override
    public List<Prescription> GetList() {
        Query q = entityManager.createQuery("SELECT id, dosage, instructions, name\n" + "FROM public.prescriptions;", entityClass);
        return q.getResultList();
    }
}
