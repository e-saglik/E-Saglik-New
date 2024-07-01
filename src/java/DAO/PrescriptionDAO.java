package DAO;

import Entity.Prescription;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class PrescriptionDAO extends AbstractDAO<Prescription> implements Serializable {

    public PrescriptionDAO() {
        super(Prescription.class);
    }

}
