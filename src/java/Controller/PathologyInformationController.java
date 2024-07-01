package Controller;

import DAO.AbstractDAO;
import DAO.PathologyInformationDAO;
import Entity.PathologyInformation;
import java.util.List;

public class PathologyInformationController extends BaseController<PathologyInformation> {

    
    public AbstractDAO getPathologyInformationDao() {
        return pathologyInformationDao;
    }

     public void setNotificationDao(PathologyInformationDAO pathologyInformationDao) {
        this.pathologyInformationDao = pathologyInformationDao;
    }

    public PathologyInformation getPathologyInformation() {
        return pathologyInformation;
    }

    public void setPathologyInformation(PathologyInformation pathologyInformation) {
        this.pathologyInformation = pathologyInformation;
    }

    public List<PathologyInformation> getPathologyInformationList() {
        return pathologyInformationList;
    }

    public void setPathologyInformationList(List<PathologyInformation> pathologyInformationList) {
        this.pathologyInformationList = pathologyInformationList;
    }

    private PathologyInformationDAO pathologyInformationDao;
    private PathologyInformation pathologyInformation;
    private List<PathologyInformation> pathologyInformationList;

    public PathologyInformationController() {

    }

 
    @Override
    public void AddEntity(PathologyInformation pathologyInformation) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.Create(pathologyInformation);

    }

    @Override
    public PathologyInformation GetEntityById(int id) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.GetById(id);
        return null;
    }

    @Override
    public List<PathologyInformation> GetEntityList() {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }

        return pathologyInformationDao.GetList();
    }

    @Override
    public void UpdateEntity(int id, PathologyInformation pathologyInformation) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.Update(pathologyInformation);
    }

    @Override
    public void DeleteEntity() {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.Delete(pathologyInformation);
    }


}
