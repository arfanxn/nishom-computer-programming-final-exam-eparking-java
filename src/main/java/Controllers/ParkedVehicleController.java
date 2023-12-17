/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Exceptions.NotFound;
import Exceptions.Validation;
import Services.ParkedVehicleService;
import Models.ParkedVehicle;
import java.sql.SQLException;
import java.util.List;
import Requests.ParkedVehicle.*;

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
    
    public List<ParkedVehicle> searchByPlateNumber(SearchByPlateNumberRequest request) throws Validation, SQLException {
        request.validate();
        List<ParkedVehicle> parkedVehicles = this.parkedVehicleService.searchByPlateNumber(request.getPlateNumber());
        return parkedVehicles;
    }
    
    public ParkedVehicle enter(EnterRequest request) throws SQLException, Validation {
        request.validate();

        ParkedVehicle parkedVehicle = new ParkedVehicle();
        parkedVehicle.setPlateNumber(request.getPlateNumber());

        parkedVehicle = this.parkedVehicleService.enter(parkedVehicle);

        return parkedVehicle;
    }
    
    public ParkedVehicle leave(LeaveRequest request) throws SQLException, Validation, NotFound {
        request.validate();

        ParkedVehicle parkedVehicle = new ParkedVehicle();
        parkedVehicle.setPlateNumber(request.getPlateNumber());

        parkedVehicle = this.parkedVehicleService.leave(parkedVehicle);

        return parkedVehicle;
    }
    
    public ParkedVehicle updatePlateNumber(UpdatePlateNumberRequest request) throws SQLException, Validation {
        request.validate();

        // TODO: implements update parked vehicle plate number by id

        return new ParkedVehicle();
    }

}
