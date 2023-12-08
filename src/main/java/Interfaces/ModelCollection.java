/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Models.ParkedVehicleCollection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arfanxn
 */
public interface ModelCollection {

    public ParkedVehicleCollection setCollection(ResultSet resultSet) throws SQLException;

}
