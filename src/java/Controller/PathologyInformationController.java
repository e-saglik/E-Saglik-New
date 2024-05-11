package Controller;

import DAO.BaseDAO;
import Entity.PathologyInformation;
import java.util.List;

public class PathologyInformationController extends BaseController<PathologyInformation> {

    public BaseDAO getPathologyInformationDao() {
        return pathologyInformationDao;
    }

    public void setPathologyInformationDao(BaseDAO pathologyInformationDao) {
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

    private BaseDAO pathologyInformationDao;
    private PathologyInformation pathologyInformation;
    private List<PathologyInformation> pathologyInformationList;

    public PathologyInformationController() {

    }

    @Override
    public void AddEntity(PathologyInformation pathologyInformation) {

    }

    @Override
    public PathologyInformation GetEntityById(int id) {
        return null;
    }

    @Override
    public List<PathologyInformation> GetEntityList() {
        return null;
    }

    @Override
    public void UpdateEntity(int id) {

    }

    @Override
    public void DeleteEntity(int id) {

    }

//    public void AddUser(User user){
//        
//    }
//    
//    public User GetUserById(int id){      
//        return null;        
//    }
//    
//    public List<User> GetUserList(){ 
//        return null;
//    }
//    
//    public void UpdateUser(int id,User user){
//        
//    }
//    
//    public void DeleteUser(int id){
//        
//    }
}
