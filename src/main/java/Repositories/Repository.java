/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author arfanxn
 * @param <T>
 *
 */
public class Repository<T extends Interfaces.Model> {

    private T model;
    private int limit, offset;
    private String keyword;
    private Connection connection;

    public Repository() {
        Configs.Database database = Configs.Database.getInstance();
        try {
            this.connection = DriverManager.getConnection(
                    database.getJdbcUrlString(),
                    database.getUsername(),
                    database.getPassword()
            );
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public <T extends Interfaces.Model> T getModel() {
        return (T) this.model;
    }

    public void setModel(T model) {
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public <T extends Interfaces.Model> ArrayList<T> pagination() throws SQLException {
        String tableName = this.getModel().getTableName();
        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("SELECT * FROM");
        queryStringBuilder.append(" ").append(tableName);
        if (this.limit != 0) {
            queryStringBuilder.append(" LIMIT ").append(Integer.toString(this.limit));
        }
        if (this.offset != 0) {
            queryStringBuilder.append(" OFFSET ").append(Integer.toString(this.offset));
        }

        PreparedStatement preparedStatement = this.connection.prepareStatement(queryStringBuilder.toString());
        ResultSet resultSet = preparedStatement.executeQuery();

        return this.model.fromResultSet(resultSet);
    }

}
