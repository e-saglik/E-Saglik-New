package Controller;

import DAO.UserDAO;
import Entity.User;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class UserController extends BaseController<User> {

    private UserDAO userDao;
    private User user;
    private List<User> userList;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserController() {

    }

    @Override
    public void AddEntity(User user) {

    }

    @Override
    public User GetEntityById(int id) {
        return null;
    }

    @Override
    public List<User> GetEntityList() {
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
