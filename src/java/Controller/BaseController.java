package Controller;

import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;

@Named
public abstract class BaseController<E>{
    
    protected E entity;
    private List<E> list;
    private final Class<E> entityClass;


    public BaseController(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract void AddEntity(E entity);

    public abstract E GetEntityById(int id);

    public abstract List<E> GetEntityList();

    public abstract void UpdateEntity(int id, E entity);

    public abstract void DeleteEntity();

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }
}
