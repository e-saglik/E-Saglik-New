package DAO;

import Entity.Donation;
import Util.DBConnection;
import java.sql.Connection;
import java.util.List;

public abstract class BaseDAO<T> extends DBConnection {

    protected Connection connection;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    public BaseDAO() {
    }

    public Connection GetConnection() {
        if (this.connection == null) {
s
            this.connection = this.connect();
        }
        return connection;
    }

    public void SetConnection(Connection connection) {
        this.connection = connection;
    }

}
