/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Containers;

import Controllers.ParkedVehicleController;
import Services.ParkedVehicleService;
import java.sql.SQLException;

/**
 *
 * @author arfanxn
 */
public class Controllers {
    
    public static ParkedVehicleController initParkedVehicle() throws SQLException {
        ParkedVehicleService service = Services.initParkedVehicle();
        ParkedVehicleController controller = new ParkedVehicleController(service);
        return controller;
    }
    
}
