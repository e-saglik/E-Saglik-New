package Controller;

import java.io.Serializable;
import java.util.List;
import jakarta.inject.Named;


@Named
public abstract class BaseController<Entity> implements Serializable{
    private Entity entity;

    public BaseController() {
        
    }

    public BaseController(Entity entity) {
        this.entity = entity;
    }
    
    public void AddEntity(Entity entity){
        
    }
    
    public Entity GetEntityById(int id){       
        return null;      
    }
    
    public List<Entity> GetEntityList(){
        return null;  
    }
    
    public void UpdateEntity(int id, Entity entity){
        
    }
    
    public void DeleteEntity(int id){
        
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    
    
}
