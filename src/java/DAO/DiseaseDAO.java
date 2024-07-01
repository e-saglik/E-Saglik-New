package DAO;

import Entity.Disease;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class DiseaseDAO extends AbstractDAO<Disease> implements Serializable {

    public DiseaseDAO() {
        super(Disease.class);
    }

}
