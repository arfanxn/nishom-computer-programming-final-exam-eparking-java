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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arfanxn
 * @param <M>
 * @param <MC>
 *
 */
public class Repository<M extends Interfaces.Model, MC extends Interfaces.ModelCollection> implements Interfaces.Repository {

    private Configs.Database databaseConfig;
    private M model;
    private MC modelCollection;
    private ResultSet resultSet;
    private int limit, offset;
    private Map<String, String> orderBys;

    public Map<String, String> getOrderBys() {
        return orderBys;
    }

    public Repository setOrderBys(HashMap<String, String> orderBys) {
        this.orderBys = orderBys;
        return this;
    }

    public Repository addOrderBy(String column, String orderBy) {
        this.orderBys = this.orderBys == null ? new HashMap<>() : this.orderBys;
        this.orderBys.put(column, orderBy);
        return this;
    }

    private String keyword;

    public Repository(Configs.Database databaseConfig, M model) {
        this.databaseConfig = databaseConfig;
        this.model = model;
    }

    @Override
    public M getModel() {
        return (M) this.model;
    }

    public Repository setModel(M model) {
        this.model = model;
        return this;
    }
    
    @Override
    public MC getModelCollection() {
        return (MC) this.modelCollection;
    }

    public Repository setModelCollection(MC modelCollection) {
        this.modelCollection = modelCollection;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public Repository setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public Repository setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public Repository setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Database getDatabase() {
        // by default when databaseConfig config isn't provided the repository will use the default one instead
        this.databaseConfig = this.databaseConfig == null ? Configs.Database.getInstance() : this.databaseConfig;
        return this.databaseConfig;
    }

    public Repository setDatabase(Database database) {
        this.databaseConfig = database;
        return this;
    }

    public Repository get() throws SQLException {
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
            if (this.orderBys.isEmpty() == false) {
                queryStringBuilder.append(" ORDER BY ");
                int index = 0;
                for (Map.Entry<String, String> set : this.orderBys.entrySet()) {
                    String column = set.getKey();
                    String orderBy = set.getValue();
                    if (index > 0) {
                        queryStringBuilder.append(", ");
                    }
                    queryStringBuilder.append(column).append(" ").append(orderBy);
                    index++;
                }
            }

            preparedStatement = connection.prepareStatement(queryStringBuilder.toString());
            this.resultSet = preparedStatement.executeQuery();
            
            return this;
        } catch (SQLException e) {
            throw e;
        } finally {
            Utilities.Database.close(connection, preparedStatement, resultSet);
        }
    }

}
