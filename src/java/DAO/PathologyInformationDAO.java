package DAO;

import Entity.PathologyInformation;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class PathologyInformationDAO extends AbstractDAO<PathologyInformation> {

    public PathologyInformationDAO() {
        super();
    }

    public void CreatePathologyInformation(PathologyInformation pathologyInformation) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(pathologyInformation);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<PathologyInformation> getPathologyInformationList() {
        TypedQuery<PathologyInformation> query = getEntityManager().createQuery("SELECT p FROM PathologyInformation p ORDER BY p.id ASC", PathologyInformation.class);
        List<PathologyInformation> pathologyInformationList = query.getResultList();
        return pathologyInformationList;
    }

    public void UpdatePathologyInformation(PathologyInformation pathologyInformation) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(pathologyInformation);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public void DeletePathologyInformation(int id) {
        PathologyInformation pathologyInformation = getEntityManager().find(PathologyInformation.class, id);
        if (pathologyInformation != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(pathologyInformation);
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                if (getEntityManager().getTransaction().isActive()) {
                    getEntityManager().getTransaction().rollback();
                }
                e.printStackTrace();
            }
        }
    }

    public PathologyInformation getPathologyInformationById(int id) {
        PathologyInformation pathologyInformation = getEntityManager().find(PathologyInformation.class, id);
        return pathologyInformation;
    }
}
