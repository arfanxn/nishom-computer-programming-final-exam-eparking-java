/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

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
