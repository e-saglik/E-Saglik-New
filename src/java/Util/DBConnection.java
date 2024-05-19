package Util;

import java.sql.*;

public abstract class DBConnection {

    public Connection connect() {
       Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/E-SaglikDB", "postgres", "05412168845Aa");

            Statement st = connection.createStatement();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage()+"ajfıowajfıowaj");
        }
        return connection;
    }
}
