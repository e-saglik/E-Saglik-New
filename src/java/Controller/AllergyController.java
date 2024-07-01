package Controller;

import DAO.AllergyDAO;
import Entity.Allergy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AllergyController extends BaseController<Allergy> {

    private AllergyDAO allergyDao;
    private EntityManagerFactory emf;
    private EntityManager em;

    public AllergyController() {
        this.emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        this.em = emf.createEntityManager();
        this.allergyDao = new AllergyDAO(em);
    }

    public AllergyDAO getAllergyDao() {
        if (this.allergyDao == null) {
            this.allergyDao = new AllergyDAO(em);
        }
        return allergyDao;
    }

    public void setAllergyDao(AllergyDAO allergyDao) {
        this.allergyDao = allergyDao;
    }

    public List<Allergy> getAllergyList() {
        return this.getAllergyDao().getAllergyList();
    }

    @Override
    public void AddEntity(Allergy allergy) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.CreateAllergy(allergy);
    }

    @Override
    public Allergy GetEntityById(int id) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        return allergyDao.getAllergyById(id);
    }

    @Override
    public List<Allergy> GetEntityList() {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        return allergyDao.getAllergyList();
    }

    @Override
    public void UpdateEntity(int id, Allergy allergy) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.UpdateAllergy(allergy);
    }

    @Override
    public void DeleteEntity() {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.DeleteAllergy(Allergy);
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
