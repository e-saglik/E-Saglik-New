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
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
