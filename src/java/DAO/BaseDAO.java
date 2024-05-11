package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection connection;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    
//    protected abstract T createFromResultSet(ResultSet resultSet) throws SQLException;
//    protected abstract String getTableName();
//
//    public void add(T entity) throws SQLException {
//        String query = "INSERT INTO " + getTableName() + " " + getInsertionColumns() + " VALUES " + getInsertionValues();
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            setInsertionParameters(statement, entity);
//            statement.executeUpdate();
//        }
//    }
//
//    public void update(T entity) throws SQLException {
//        String query = "UPDATE " + getTableName() + " SET " + getUpdateSetClause() + " WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            setUpdateParameters(statement, entity);
//            statement.executeUpdate();
//        }
//    }
//
//    public void delete(int id) throws SQLException {
//        String query = "DELETE FROM " + getTableName() + " WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//    }
//
//    public List<T> getAll() throws SQLException {
//        List<T> entities = new ArrayList<>();
//        String query = "SELECT * FROM " + getTableName();
//        try (PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                entities.add(createFromResultSet(resultSet));
//            }
//        }
//        return entities;
//    }
//
//    public T getById(int id) throws SQLException {
//        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    return createFromResultSet(resultSet);
//                }
//            }
//        }
//        return null;
//    }
//
//    
//    protected abstract String getInsertionColumns();
//    protected abstract String getInsertionValues();
//    protected abstract void setInsertionParameters(PreparedStatement statement, T entity) throws SQLException;
//    protected abstract String getUpdateSetClause();
//    protected abstract void setUpdateParameters(PreparedStatement statement, T entity) throws SQLException;
}

