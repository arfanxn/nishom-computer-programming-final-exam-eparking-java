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
    protected StringBuilder stringBuilder;
    protected int totalAffectedRows;

    public Repository(Configs.Database databaseConfig) throws SQLException {
        // by default when databaseConfig config isn't provided the repository will use the default one instead
        this.databaseConfig = this.databaseConfig == null ? Configs.Database.getInstance() : this.databaseConfig;
        this.stringBuilder = new StringBuilder();
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
    
    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder sb) {
        this.stringBuilder = sb;
    }

    public int getTotalAffectedRows() {
        return this.totalAffectedRows;
    }

    public void setTotalAffectedRows(int totalAffectedRows) {
        this.totalAffectedRows = totalAffectedRows;
    }

    // openConnection opens a new connection
    public Repository openConnection() throws SQLException {
        this.connection = DriverManager.getConnection(this.databaseConfig.getJdbcUrlString());
        return this;
    }

    // closeConnection resets the string builder and closes the connection
    public Repository closeConnection() {
        this.stringBuilder = new StringBuilder(); // reset string builder 

        try {
            this.resultSet.close();
        } catch (Exception e) {
            /* Ignored */ }
        try {
            this.preparedStatement.close();
        } catch (Exception e) {
            /* Ignored */ }
        try {
            this.connection.close();
        } catch (Exception e) {
            /* Ignored */ }

        return this;
    }

}
