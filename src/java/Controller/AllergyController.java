package Controller;

import DAO.AllergyDAO;
import Entity.Allergy;
import java.util.List;

public class AllergyController extends BaseController<Allergy> {

    private AllergyDAO allergyDao;
    private Allergy allergy;
    private List<Allergy> allergyList;

    public AllergyController() {

    }

    public AllergyDAO getAllergyDao() {
        if (this.allergyDao == null) {
            this.allergyDao = new AllergyDAO();
        }
        return allergyDao;
    }

    public void setAllergyDao(AllergyDAO allergyDao) {
        this.allergyDao = allergyDao;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public List<Allergy> getAllergyList() {
        this.allergyList = this.getAllergyDao().getAllergyList();
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
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
        allergyDao.getAllergyById(id);
        return null;
    }

    @Override
    public List<Allergy> GetEntityList() {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyList = allergyDao.getAllergyList();
        return allergyList;
    }

    @Override
    public void UpdateEntity(int id, Allergy allergy) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.UpdateAllergy(allergy);
    }

    @Override
    public void DeleteEntity(int id) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.DeleteAllergy(id);
    }

}
