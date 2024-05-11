package Controller;

import DAO.DiseaseDAO;
import Entity.Disease;
import java.util.List;

public class DiseaseController extends BaseController<Disease> {

    private DiseaseDAO diseaseDao;
    private Disease disease;
    private List<Disease> diseaseList;

    public DiseaseController() {

    }

    @Override
    public void AddEntity(Disease disease) {

    }

    @Override
    public Disease GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Disease> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
