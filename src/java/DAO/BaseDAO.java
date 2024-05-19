package DAO;

import Util.DBConnection;
import java.sql.Connection;


public abstract class BaseDAO<T> extends DBConnection {
    protected Connection connection;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    public BaseDAO() {
    }

    public Connection GetConnection() {
        if(this.connection == null){
            
            this.connection = this.connect();
        }
        return connection;
    }

    public void SetConnection(Connection connection) {
        this.connection = connection;
    }

    

}

