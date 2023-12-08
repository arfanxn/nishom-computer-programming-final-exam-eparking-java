/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleCollection implements Interfaces.ModelCollection {

    private ArrayList<ParkedVehicle> collection;
    
    public ArrayList<ParkedVehicle> getCollection () {
        return this.collection;
    }

    /**
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    @Override
    public ParkedVehicleCollection setCollection(ResultSet resultSet) throws SQLException {
        this.collection = new ArrayList<>();

        int index = 0;
        while (resultSet.next()) {
            ParkedVehicle parkedVehicle = new ParkedVehicle();
            parkedVehicle.setId(resultSet.getString("id"));
            parkedVehicle.setVehiclePlateNumber(resultSet.getString("vehicle_plate_number"));
            parkedVehicle.setEnteredAt(resultSet.getDate("entered_at"));
            parkedVehicle.setLeftAt(resultSet.getDate("left_at"));
            this.collection.add(index, parkedVehicle);

            index++;
        }

        return this;
    }

}
