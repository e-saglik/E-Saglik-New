package Controller;

import DAO.BaseDAO;
import DAO.RadiographDAO;
import Entity.Radiograph;
import java.util.List;

public class RadiographController extends BaseController<Radiograph> {

    public BaseDAO getRadiographDao() {
        return radiographDao;
    }

    public void setRadiographDao(RadiographDAO radiographDao) {
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

    private RadiographDAO radiographDao;
    private Radiograph radiograph;
    private List<Radiograph> radiographList;

    public RadiographController() {

    }

   @Override
    public Radiograph GetEntityById(int id) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.getRadiographById(id);
        return null;
    }

    @Override
    public List<Radiograph> GetEntityList() {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.getRadiographList();

        return radiographDao.getRadiographList();
    }

    @Override
    public void UpdateEntity(int id, Radiograph radiograph) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.UpdateRadiograph(radiograph);
    }

    @Override
    public void DeleteEntity(int id) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.DeleteRadiograph(id);
    }


}
