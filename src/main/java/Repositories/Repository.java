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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arfanxn
 *
 */
public class Repository {

    private Configs.Database databaseConfig;
    private int limit, offset;
    private Map<String, String> orderBys;
    private String keyword;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private StringBuilder queryStringBuilder;
    
    public Repository(Configs.Database databaseConfig) {
        this.databaseConfig = databaseConfig;
        this.orderBys = new HashMap<>();
    }
   

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

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
    
    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
    
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSetMetaData getResultSetMetaData() {
        return resultSetMetaData;
    }
    
    public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
        this.resultSetMetaData = resultSetMetaData;
    }

    public String getQueryString () {
        return this.queryStringBuilder != null ? this.queryStringBuilder.toString() : "";
    }

    protected Repository buildSelectQueryString(String tableName) {
        this.queryStringBuilder = new StringBuilder();
        this.queryStringBuilder.append("SELECT * FROM");
        this.queryStringBuilder.append(" ").append(tableName);
        if (this.limit != 0) {
            queryStringBuilder.append(" LIMIT ").append(Integer.toString(this.limit));
        }
        if (this.offset != 0) {
            this.queryStringBuilder.append(" OFFSET ").append(Integer.toString(this.offset));
        }
        if (this.orderBys.isEmpty() == false) {
            this.queryStringBuilder.append(" ORDER BY ");
            int index = 0;
            for (Map.Entry<String, String> set : this.orderBys.entrySet()) {
                String column = set.getKey();
                String orderBy = set.getValue();
                if (index > 0) {
                    this.queryStringBuilder.append(", ");
                }
                this.queryStringBuilder.append(column).append(" ").append(orderBy);
                index++;
            }
        }
        return this;
    }

    public Repository openConnection() throws SQLException {
        this.connection = DriverManager.getConnection(this.databaseConfig.getJdbcUrlString());
        return this;
    }

    public Repository closeConnection() {
        Utilities.Database.close(this.connection, this.preparedStatement, this.resultSet);
        return this;
    }

}
