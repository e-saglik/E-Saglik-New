package Controller;

import DAO.AbstractDAO;
import DAO.RadiographDAO;
import Entity.Radiograph;
import java.util.List;

public class RadiographController extends BaseController<Radiograph> {

    public AbstractDAO getRadiographDao() {
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
        radiographDao.getById(id);
        return null;
    }

    @Override
    public List<Radiograph> GetEntityList() {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.getEntities();

        return radiographDao.getEntities();
    }

    @Override
    public void UpdateEntity(int id, Radiograph radiograph) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.Update(radiograph);
    }

    @Override
    public void DeleteEntity() {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.Delete(radiograph);
    }

    @Override
    public void AddEntity(Radiograph entity) {
        if (radiographDao == null) {
            radiographDao = new RadiographDAO();
        }
        radiographDao.Create(radiograph);
    }


}
