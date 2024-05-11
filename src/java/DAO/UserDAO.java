package DAO;

import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO  extends BaseDAO{
    private Connection connection;

    public UserDAO (Connection connection) {
        super(connection);
    }

}
