/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicle implements Interfaces.Model {

    private String tableName;
    private String[] columnNames;
    private String id;
    private String plateNumber;
    private java.util.Date enteredAt;
    private java.util.Date leftAt;
    private java.util.Date updatedAt;

    private void setup () {
        this.tableName = "parked_vehicles";
        this.columnNames = new String[]{"id", "plate_number", "entered_at", "left_at", "updated_at"};
    }

    public ParkedVehicle() {
        this.setup();
    }
    
    public ParkedVehicle(
            String id,
            String plateNumber,
            java.util.Date enteredAt,
            java.util.Date leftAt,
            java.util.Date updatedAt
    ) {
        this.setup();

        this.id = id;
        this.plateNumber = plateNumber;
        this.enteredAt = enteredAt;
        this.leftAt = leftAt;
        this.updatedAt = updatedAt;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
    
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String[] getColumnNames() {
        return this.columnNames;
    }
    
    @Override
    public Object[] getValues() {
        return new Object[]{
            this.getId(),
            this.getPlateNumber(),
            this.getEnteredAt(),
            this.getLeftAt(),
            this.getUpdatedAt()
        };
    }

    public ParkedVehicle fillByResultSet(ResultSet resultSet) throws SQLException {
        String[] cns = this.getColumnNames();
        this.setId(resultSet.getString(cns[0]));
        this.setPlateNumber(resultSet.getString(cns[1]));
        this.setEnteredAt(resultSet.getDate(cns[2]));
        this.setLeftAt(resultSet.getDate(cns[3]));
        this.setUpdatedAt(resultSet.getDate(cns[4]));
        return this;
    }
    
}
