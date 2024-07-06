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

     @Override
    public void Create(Disease entity) {
        try {
            entityManager.persist(entity);
            entityManager.flush();  // Ensure the changes are saved immediately
            System.out.println("Entity created successfully: " + entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating entity", e);
        }
    }
}
