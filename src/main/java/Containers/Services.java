/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Containers;

import Services.ParkedVehicleService;
import Repositories.ParkedVehicleRepository;
import java.sql.SQLException;

/**
 *
 * @author arfanxn
 */
public class Services {

    public static ParkedVehicleService initParkedVehicle() throws SQLException {
        ParkedVehicleRepository repository = Repositories.initParkedVehicle();
        ParkedVehicleService service = new ParkedVehicleService(repository);
        return service;
    }
    
}
