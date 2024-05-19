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
    public User GetEntityById(int id) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.GetUserById(id);
        return null;
    }

    @Override
    public List<User> GetEntityList() {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.GetUserList();

        return userDao.GetUserList();
    }

    @Override
    public void UpdateEntity(int id, User user) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.UpdateUser(user);
    }

    @Override
    public void DeleteEntity(int id) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.DeleteUser(id);
    }

}
