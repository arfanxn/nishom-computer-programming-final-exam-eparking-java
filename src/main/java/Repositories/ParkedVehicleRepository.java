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
            this.collection.add((new ParkedVehicle()).fillByResultSet(this.resultSet));
        }

        return this;
    }

    public ParkedVehicleRepository create(Models.ParkedVehicle model) throws SQLException {
        this.queryBuilder.buildInsertQuery(1);
        String queryString = this.queryBuilder.getString();
        System.out.println(queryString);

        this.preparedStatement = this.connection.prepareStatement(queryString);
        UUID uuid = UUID.randomUUID();
        this.preparedStatement.setString(1, uuid.toString());
        this.preparedStatement.setString(2, model.getPlateNumber());
        this.preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));
        this.preparedStatement.setNull(4, java.sql.Types.DATE);
        this.preparedStatement.setNull(5, java.sql.Types.DATE);
        this.totalAffectedRows = this.preparedStatement.executeUpdate();

        return this;
    }
    
    // update by id
    public ParkedVehicleRepository update(Models.ParkedVehicle model) throws SQLException {
        this.queryBuilder.addWhere("id", "=", model.getId());
        this.queryBuilder.buildUpdateQuery();
        String queryString = this.queryBuilder.getString();

        this.preparedStatement = this.connection.prepareStatement(queryString);
        Date sqlDateNow = new Date(new java.util.Date().getTime());
        this.preparedStatement.setString(1, model.getId());
        this.preparedStatement.setString(2, model.getPlateNumber());
        this.preparedStatement.setDate(3, new Date(model.getEnteredAt().getTime()));
        this.preparedStatement.setDate(4, new Date(model.getLeftAt().getTime()));
        this.preparedStatement.setDate(5, sqlDateNow);
        this.preparedStatement.setString(5, model.getId()); // fills the where condition
        this.totalAffectedRows = this.preparedStatement.executeUpdate();

        return this;
    }

}
