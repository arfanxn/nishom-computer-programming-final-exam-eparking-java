/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Configs.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author arfanxn
 * @param <M>
 *
 */
public class Repository<M extends Interfaces.Model> implements Interfaces.Repository {

    private Configs.Database databaseConfig;
    private M model;
    private int limit, offset;
    private String keyword;
    
    public Repository(Configs.Database databaseConfig, M model) {
        this.databaseConfig = databaseConfig;
        this.model = model;
    }

    @Override
    public M getModel() {
        return (M) this.model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Database getDatabase() {
        // by default when databaseConfig config isn't provided the repository will use the default one instead
        this.databaseConfig = this.databaseConfig == null ? Configs.Database.getInstance() : this.databaseConfig;
        return this.databaseConfig;
    }

    public void setDatabase(Database database) {
        this.databaseConfig = database;
    }

    public <T extends Interfaces.Model> ArrayList<T> get() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(databaseConfig.getJdbcUrlString());

            StringBuilder queryStringBuilder = new StringBuilder();
            queryStringBuilder.append("SELECT * FROM");
            queryStringBuilder.append(" ").append(this.getModel().getTableName());
            if (this.limit != 0) {
                queryStringBuilder.append(" LIMIT ").append(Integer.toString(this.limit));
            }
            if (this.offset != 0) {
                queryStringBuilder.append(" OFFSET ").append(Integer.toString(this.offset));
            }

            preparedStatement = connection.prepareStatement(queryStringBuilder.toString());
            resultSet = preparedStatement.executeQuery();

            return this.model.fromResultSet(resultSet);
        } catch (SQLException e) {
            throw e;
        } finally {
            Utilities.Database.close(connection, preparedStatement, resultSet);
        }
    }

}
