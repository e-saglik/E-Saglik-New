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
        this.allergyList = this.getAllergyDao().GetList();
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
        allergyDao.Create(allergy);

    }

    @Override
    public Allergy GetEntityById(int id) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.GetById(id);
        return null;
    }

    @Override
    public List<Allergy> GetEntityList() {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyList = allergyDao.GetList();
        return allergyList;
    }

    @Override
    public void UpdateEntity(int id, Allergy allergy) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.Update(allergy);
    }

    @Override
    public void DeleteEntity() {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.Delete(allergy);
    }

}
