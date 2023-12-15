/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Configs.Database;
import Utilities.QueryBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author arfanxn
 *
 */
public class Repository {

    private Configs.Database databaseConfig;
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    protected ResultSetMetaData resultSetMetaData;
    protected QueryBuilder queryBuilder;
    protected int totalAffectedRows;

    public Repository(Configs.Database databaseConfig) throws SQLException {
        // by default when databaseConfig config isn't provided the repository will use the default one instead
        this.databaseConfig = this.databaseConfig == null ? Configs.Database.getInstance() : this.databaseConfig;
        this.connection = DriverManager.getConnection(databaseConfig.getJdbcUrlString());
        this.queryBuilder = new QueryBuilder();
    }

    public Database getDatabase() {
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

    public void setResultSet(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        this.resultSetMetaData = this.resultSet.getMetaData();
    }

    public ResultSetMetaData getResultSetMetaData() throws SQLException {
        this.resultSetMetaData = this.resultSetMetaData == null ? this.resultSet.getMetaData() : this.resultSetMetaData;
        return this.resultSetMetaData;
    }

    public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
        this.resultSetMetaData = resultSetMetaData;
    }
    
    public QueryBuilder getQueryBuilder() {
        return queryBuilder;
    }

    public void setQueryBuilder(QueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }
    
    
    public int getTotalAffectedRows() {
        return this.totalAffectedRows;
    }

    public void setTotalAffectedRows(int totalAffectedRows) {
        this.totalAffectedRows = totalAffectedRows;
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
