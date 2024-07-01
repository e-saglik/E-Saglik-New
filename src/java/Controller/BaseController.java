package Controller;

import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;

@Named
public abstract class BaseController<Entity> implements Serializable {
    private Entity entity;

    public BaseController() {
    }

    public BaseController(Entity entity) {
        this.entity = entity;
    }

    public abstract void AddEntity(Entity entity);

    public abstract Entity GetEntityById(int id);

    public abstract List<Entity> GetEntityList();

    public abstract void UpdateEntity(int id, Entity entity);

    public abstract void DeleteEntity();

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
