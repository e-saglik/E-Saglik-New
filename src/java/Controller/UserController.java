package Controller;

import DAO.UserDAO;
import Entity.User;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class UserController extends BaseController<User> {

    private UserDAO userDao;
    private User user;
    private List<User> userList;

    public String login(){
        if(this.user.getEmail().equals("kullanıcı") && this.user.getPassword().equals("123")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "/index?faces-redirct=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/login";
        }
    }
    
    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        if(this.user == null){
            this.user= new User();
        }
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
        userDao.getById(id);
        return null;
    }

    @Override
    public List<User> GetEntityList() {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.getEntities();

        return userDao.getEntities();
    }

    @Override
    public void UpdateEntity(int id, User user) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.Update(user);
    }

    @Override
    public void DeleteEntity() {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.Delete(user);
    }

    @Override
    public void AddEntity(User entity) {
        if (userDao == null) {
            userDao = new UserDAO();
        }
        userDao.Create(user);
    }

}
