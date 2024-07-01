package DAO;

import Entity.Doctor;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class DoctorDAO extends AbstractDAO<Doctor> implements Serializable {

    public DoctorDAO() {
        super(Doctor.class);
    }

}
