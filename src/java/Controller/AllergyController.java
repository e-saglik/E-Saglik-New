package Controller;

import DAO.AllergyDAO;
import Entity.Allergy;
import Entity.Doctor;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AllergyController extends BaseController<Allergy> implements Serializable {

    @EJB
    private AllergyDAO allergyDao;

    private Allergy allergy;
    private List<Allergy> allergyList;

    public AllergyController() {
        super(Allergy.class);
    }

    public AllergyDAO getAllergyDao() {
        if (this.allergyDao == null) {
            this.allergyDao = new AllergyDAO();
        }
        return allergyDao;
    }

    public void setAllergyDao(AllergyDAO allergyDao) {
        this.allergyDao = allergyDao;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public List<Allergy> getAllergyList() {
        this.allergyList = this.getAllergyDao().GetList();
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    @Override
    public void AddEntity() {
        getAllergyDao().Create(this.entity);
        this.entity = new Allergy();

    }

    @Override
    public Allergy GetEntityById(int id) {
        if (allergyDao == null) {
            allergyDao = new AllergyDAO();
        }
        allergyDao.GetById(id);
        return null;
    }

    @Override
    public List<Allergy> GetEntityList() {
         return getAllergyDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getAllergyDao().Update(allergy);
        this.entity = new Allergy();
    }

    @Override
    public void DeleteEntity() {
             allergyDao.Delete(entity);
        this.entity = new Allergy();
    }

}
