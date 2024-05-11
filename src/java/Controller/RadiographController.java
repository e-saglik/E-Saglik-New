package Controller;

import DAO.BaseDAO;
import Entity.Radiograph;
import java.util.List;

public class RadiographController extends BaseController<Radiograph> {

    public BaseDAO getRadiographDao() {
        return radiographDao;
    }

    public void setRadiographDao(BaseDAO radiographDao) {
        this.radiographDao = radiographDao;
    }

    public Radiograph getRadiograph() {
        return radiograph;
    }

    public void setRadiograph(Radiograph radiograph) {
        this.radiograph = radiograph;
    }

    public List<Radiograph> getRadiographList() {
        return radiographList;
    }

    public void setRadiographList(List<Radiograph> radiographList) {
        this.radiographList = radiographList;
    }

    private BaseDAO radiographDao;
    private Radiograph radiograph;
    private List<Radiograph> radiographList;

    public RadiographController() {

    }

    @Override
    public void AddEntity(Radiograph radiograph) {

    }

    @Override
    public Radiograph GetEntityById(int id) {
        return null;
    }

    @Override
    public List<Radiograph> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id, Radiograph radiograph) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

}
