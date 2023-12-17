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

    // all
    public ParkedVehicleRepository all() throws SQLException {
        this.openConnection();
        
        this.qsb
                .append("SELECT * FROM ")
                .append(this.model.getTableName())
                .append(" ORDER BY `entered_at` DESC");

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        this.resultSet = preparedStatement.executeQuery();
        this.resultSetMetaData = this.resultSet.getMetaData();

        this.collection = new ArrayList<>();
        while (this.resultSet.next()) {
            this.collection.add((new ParkedVehicle()).fillByResultSet(this.resultSet));
        }

        this.closeConnection();
        return this;
    }
    
    public ParkedVehicleRepository searchByPlateNumber(String plateNumber) throws SQLException {
        this.openConnection();

        this.qsb
                .append("SELECT * FROM ")
                .append(this.model.getTableName())
                .append(" WHERE `plate_number` LIKE ?")
                .append(" ORDER BY `entered_at` DESC");
                
        
        System.out.println("Query string");
        System.out.println(this.qsb.toString());

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        this.preparedStatement.setString(1, "%" + plateNumber + "%");
        this.resultSet = preparedStatement.executeQuery();
        this.resultSetMetaData = this.resultSet.getMetaData();

        this.collection = new ArrayList<>();
        while (this.resultSet.next()) {
            this.collection.add((new ParkedVehicle()).fillByResultSet(this.resultSet));
        }

        this.closeConnection();
        return this;
    }
    
    // find finds by id 
    public ParkedVehicleRepository find(String id) throws SQLException {
        this.openConnection();
        
        this.qsb
                .append("SELECT * FROM ")
                .append(this.model.getTableName())
                .append(" WHERE id = ?");

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        this.preparedStatement.setString(1, id); // sets where id = ? 
        this.resultSet = preparedStatement.executeQuery();
        this.resultSetMetaData = this.resultSet.getMetaData();

        this.collection = new ArrayList<>();
        while (this.resultSet.next()) {
            this.model = (new ParkedVehicle()).fillByResultSet(this.resultSet);
            this.collection.add((new ParkedVehicle()).fillByResultSet(this.resultSet));
        }

        this.closeConnection();
        return this;
    }
    
    // findByPlateNumber finds by plate number
    public ParkedVehicleRepository findByPlateNumber(String plateNumber) throws SQLException {
        this.openConnection();
        
        this.qsb
                .append("SELECT * FROM ")
                .append(this.model.getTableName())
                .append(" WHERE plate_number = ?");

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        this.preparedStatement.setString(1, plateNumber); // sets where plate_number = ? 
        this.resultSet = preparedStatement.executeQuery();
        this.resultSetMetaData = this.resultSet.getMetaData();

        this.collection = new ArrayList<>();
        while (this.resultSet.next()) {
            this.model = (new ParkedVehicle()).fillByResultSet(this.resultSet);
            this.collection.add((new ParkedVehicle()).fillByResultSet(this.resultSet));
        }

        this.closeConnection();
        return this;
    }

    // insert
    public ParkedVehicleRepository insert(List<Models.ParkedVehicle> parkedVehicles) throws SQLException {
        this.openConnection();
        
        this.qsb
                .append("INSERT INTO ")
                .append(this.model.getTableName())
                .append(" (")
                .append(String.join(", ", this.model.getColumnNames()))
                .append(")")
                .append(" VALUES")
                .append(" (")
                .append("?, ".repeat(this.model.getValues().length - 1)).append("?")
                .append(")");

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        
        int i = 0;
        for (ParkedVehicle parkedVehicle : parkedVehicles) {
            this.preparedStatement.setObject(1, parkedVehicle.getId());
            this.preparedStatement.setObject(2, parkedVehicle.getPlateNumber());
            this.preparedStatement.setObject(3, parkedVehicle.getEnteredAt());
            this.preparedStatement.setObject(4, parkedVehicle.getLeftAt());
            this.preparedStatement.setObject(5, parkedVehicle.getUpdatedAt());
            
            this.preparedStatement.addBatch();
            i++;
            
            if (i % 100 == 0 || i == parkedVehicles.size()) {
                int[] tars = this.preparedStatement.executeBatch(); // Execute every 100 items.
                for (int tar : tars)
                    this.totalAffectedRows += tar;
            }
        }

        this.closeConnection();
        return this;
    }
    
    // update by id or ids
    public ParkedVehicleRepository update(List<Models.ParkedVehicle> parkedVehicles) throws SQLException {
        this.openConnection();
        
        int columnNamesLength = this.model.getColumnNames().length;
        this.qsb
                .append("UPDATE ")
                .append(this.model.getTableName())
                .append(" SET ");
        for (int i = 0; i < columnNamesLength; i++) {
            String columnName = this.model.getColumnNames()[i];
            this.qsb
                    .append(columnName)
                    .append(" = ?");
            this.qsb.append((i < (columnNamesLength - 1)) ? ", " : "");
        }
        this.qsb.append(" WHERE id = ?");

        this.preparedStatement = this.connection.prepareStatement(this.qsb.toString());
        
        int i = 0;
        for (ParkedVehicle parkedVehicle : parkedVehicles) {
            this.preparedStatement.setObject(1, parkedVehicle.getId());
            this.preparedStatement.setObject(2, parkedVehicle.getPlateNumber());
            this.preparedStatement.setObject(3, parkedVehicle.getEnteredAt());
            this.preparedStatement.setObject(4, parkedVehicle.getLeftAt());
            this.preparedStatement.setObject(5, parkedVehicle.getUpdatedAt());
            this.preparedStatement.setObject(6, parkedVehicle.getId()); // where id = ? 

            this.preparedStatement.addBatch();
            i++;

            if (i % 100 == 0 || i == parkedVehicles.size()) {
                int[] tars = this.preparedStatement.executeBatch(); // Execute every 100 items.
                for (int tar : tars) {
                    this.totalAffectedRows += tar;
                }
            }
        }

        this.closeConnection();
        return this;
    }
    


}
