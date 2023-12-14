/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Configs.Database;
import java.util.List;
import Models.ParkedVehicle;
import java.sql.SQLException;
import java.util.ArrayList;


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
        this.buildSelectQueryString(this.model.getTableName());

        // Assign the values
        this.setPreparedStatement(this.getConnection().prepareStatement(this.getQueryString()));
        this.setResultSet(this.getPreparedStatement().executeQuery());
        this.setResultSetMetaData(this.getResultSet().getMetaData());

        while (this.getResultSet().next()) {
            this.collection = this.collection == null ? new ArrayList<>() : this.collection;
            this.collection.add(model.fillByResultSet(this.getResultSet()));
        }

        return this;
    }

    

}
