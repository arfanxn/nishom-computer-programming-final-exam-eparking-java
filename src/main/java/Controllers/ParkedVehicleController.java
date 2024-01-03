/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Forms.ParkedVehicle.PlateNumberForm;
import Exceptions.NotFound;
import Exceptions.Validation;
import Services.ParkedVehicleService;
import Models.ParkedVehicle;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleController {
    
    ParkedVehicleService parkedVehicleService;

    public ParkedVehicleController(ParkedVehicleService parkedVehicleService) {
        this.parkedVehicleService = parkedVehicleService;
    }
    
    public List<ParkedVehicle> all() throws SQLException {
        return this.parkedVehicleService.all();
    }
    
    public List<ParkedVehicle> searchByPlateNumber(PlateNumberForm form) throws SQLException {
        if (form.getPlateNumber().isEmpty()) {
            return this.all();
        }
        System.out.println("------------------------------");
        System.out.println("Plate number: ");
        System.out.println(form.getPlateNumber());
        System.out.println(form.getPlateNumber().length());
        System.out.println("------------------------------");
        
        List<ParkedVehicle> parkedVehicles = this.parkedVehicleService.searchByPlateNumber(form.getPlateNumber());
        return parkedVehicles;
    }
    
    public ParkedVehicle enter(PlateNumberForm form) throws SQLException, Validation {
        form.validate();

        ParkedVehicle parkedVehicle = new ParkedVehicle();
        parkedVehicle.setPlateNumber(form.getPlateNumber());

        parkedVehicle = this.parkedVehicleService.enter(parkedVehicle);

        return parkedVehicle;
    }
    
    public ParkedVehicle leave(PlateNumberForm form) throws SQLException, Validation, NotFound {
        form.validate();

        ParkedVehicle parkedVehicle = new ParkedVehicle();
        parkedVehicle.setPlateNumber(form.getPlateNumber());

        parkedVehicle = this.parkedVehicleService.leave(parkedVehicle);

        return parkedVehicle;
    }

}
