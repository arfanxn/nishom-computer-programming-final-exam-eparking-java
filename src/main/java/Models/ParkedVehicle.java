/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicle implements Interfaces.Model {

    private final String tableName;

    public ParkedVehicle() {
        this.tableName = "parked_vehicles";

    }

    private String id;
    private String vehiclePlateNumber;
    private java.util.Date enteredAt;
    private java.util.Date leftAt;

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ParkedVehicle> fromResultSet(ResultSet resultSet) throws SQLException {
        var parkedVehicles = new ArrayList<ParkedVehicle>();

        int index = 0;
        while (resultSet.next()) {
            ParkedVehicle parkedVehicle = new ParkedVehicle();
            parkedVehicle.setId(resultSet.getString("id"));
            parkedVehicle.setVehiclePlateNumber(resultSet.getString("vehicle_plate_number"));
            parkedVehicle.setEnteredAt(resultSet.getDate("entered_at"));
            parkedVehicle.setLeftAt(resultSet.getDate("left_at"));
            parkedVehicles.add(index, parkedVehicle);

            index++;
        }

        return parkedVehicles;
    }

    @Override
    public String getTableName() {
        return this.tableName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public Date getEnteredAt() {
        return enteredAt;
    }

    public void setEnteredAt(Date enteredAt) {
        this.enteredAt = enteredAt;
    }

    public Date getLeftAt() {
        return leftAt;
    }

    public void setLeftAt(Date leftAt) {
        this.leftAt = leftAt;
    }
}
