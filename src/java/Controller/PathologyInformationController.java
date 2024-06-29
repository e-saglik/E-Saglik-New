package Controller;

import DAO.BaseDAO;
import DAO.PathologyInformationDAO;
import Entity.PathologyInformation;
import java.util.List;

public class PathologyInformationController extends BaseController<PathologyInformation> {

    
    public BaseDAO getPathologyInformationDao() {
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
        pathologyInformationDao.CreatePathologyInformation(pathologyInformation);

    }

    @Override
    public PathologyInformation GetEntityById(int id) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.getPathologyInformationById(id);
        return null;
    }

    @Override
    public List<PathologyInformation> GetEntityList() {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.getPathologyInformationList();

        return pathologyInformationDao.getPathologyInformationList();
    }

    @Override
    public void UpdateEntity(int id, PathologyInformation pathologyInformation) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.UpdatePathologyInformation(pathologyInformation);
    }

    @Override
    public void DeleteEntity(int id) {
        if (pathologyInformationDao == null) {
            pathologyInformationDao = new PathologyInformationDAO();
        }
        pathologyInformationDao.DeletePathologyInformation(id);
    }


}
