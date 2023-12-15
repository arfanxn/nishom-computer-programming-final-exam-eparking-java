/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Configs.Database;
import java.util.List;
import Models.ParkedVehicle;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleRepository extends Repository {

    private ParkedVehicle model;
    private List<ParkedVehicle> collection;

    public ParkedVehicleRepository(Database databaseConfig) throws SQLException {
        super(databaseConfig);
        this.model = new ParkedVehicle();
        this.queryBuilder.fillByModel(this.model);
    }

    public ParkedVehicle getModel() {
        return model;
    }

    public void setModel(ParkedVehicle model) {
        this.model = model;
    }

    public List<ParkedVehicle> getCollection() {
        return collection;
    }

    public ParkedVehicleRepository get() throws SQLException {
        this.queryBuilder.buildSelectQuery();
        String queryString = this.queryBuilder.getString();

        // Assign the values
        this.preparedStatement = this.connection.prepareStatement(queryString);
        this.resultSet = preparedStatement.executeQuery();
        this.resultSetMetaData = this.resultSet.getMetaData();

        while (this.resultSet.next()) {
            this.collection = this.collection == null ? new ArrayList<>() : this.collection;
            this.collection.add(model.fillByResultSet(this.resultSet));
        }

        return this;
    }

    public ParkedVehicleRepository create(Models.ParkedVehicle model) throws SQLException {
        this.queryBuilder.buildInsertQuery(1);

        this.preparedStatement = this.connection.prepareStatement(this.queryBuilder.getString());
        UUID uuid = UUID.randomUUID();
        this.preparedStatement.setString(1, uuid.toString());
        this.preparedStatement.setString(2, model.getPlateNumber());
        this.preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
        this.preparedStatement.setDate(4, null);
        this.preparedStatement.setDate(5, null);
        this.setResultSet(this.preparedStatement.executeQuery());

        System.out.println(this.getResultSetMetaData());

        return this;
    }

}
