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
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    @Override
    public void AddEntity(Allergy allergy) {

    }

    @Override
    public Allergy GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Allergy> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Allergy allergy) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
