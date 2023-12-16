/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Containers;

import Repositories.ParkedVehicleRepository;
import java.sql.SQLException;

/**
 *
 * @author arfanxn
 */
public class Repositories {

    public static ParkedVehicleRepository initParkedVehicle() throws SQLException {
        var databaseConfig = Configs.Database.getInstance();
        ParkedVehicleRepository repository = new ParkedVehicleRepository(databaseConfig);
        return repository;
    }

}
