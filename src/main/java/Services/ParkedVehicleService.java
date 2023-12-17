/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Exceptions.NotFound;
import Repositories.ParkedVehicleRepository;
import Models.ParkedVehicle;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleService {
    
    ParkedVehicleRepository parkedVehicleRepository;

    public ParkedVehicleService(ParkedVehicleRepository parkedVehicleRepository) {
        this.parkedVehicleRepository = parkedVehicleRepository;
    }
    
    public List<ParkedVehicle> all() throws SQLException {
        this.parkedVehicleRepository.all();
        return this.parkedVehicleRepository.getCollection();
    }
    
    public List<ParkedVehicle> searchByPlateNumber(String plateNumber) throws SQLException {
        this.parkedVehicleRepository.searchByPlateNumber(plateNumber);
        return this.parkedVehicleRepository.getCollection();
    }
    
    // enter enters (inserts) a vehicle
    public ParkedVehicle enter(ParkedVehicle parkedVehicle) throws SQLException {
        parkedVehicle.setId(UUID.randomUUID().toString()); // set id from generated uuid 
        parkedVehicle.setPlateNumber(parkedVehicle.getPlateNumber()); // set plate number based on input
        parkedVehicle.setEnteredAt(new java.util.Date());
        parkedVehicle.setLeftAt(null);
        parkedVehicle.setUpdatedAt(null);
        this.parkedVehicleRepository.insert(List.of(parkedVehicle));
        return parkedVehicle;
    }
    
    // leave updates the parked vehicle left at column
    public ParkedVehicle leave(ParkedVehicle parkedVehicle) throws SQLException, NotFound {

        this.parkedVehicleRepository.findByPlateNumber(parkedVehicle.getPlateNumber());
        if (this.parkedVehicleRepository.getCollection().isEmpty()) {
            throw new NotFound("Parked vehicle with plate number: " + parkedVehicle.getPlateNumber() + " was not found");
        }
        
        parkedVehicle = this.parkedVehicleRepository.getCollection().get(0);
        var now = new java.util.Date();
        parkedVehicle.setLeftAt(now);
        parkedVehicle.setUpdatedAt(now);

        this.parkedVehicleRepository.update(List.of(parkedVehicle));
        return parkedVehicle;
    }
    
    // updatePlateNumber updates the parked vehicle plate number by id
    public ParkedVehicle updatePlateNumber(ParkedVehicle parkedVehicle) throws SQLException {

        String plateNumber = parkedVehicle.getPlateNumber();
        parkedVehicle = this.parkedVehicleRepository.findByPlateNumber(parkedVehicle.getPlateNumber()).getCollection().get(0);

        parkedVehicle.setPlateNumber(plateNumber);

        this.parkedVehicleRepository.update(List.of(parkedVehicle));
        return parkedVehicle;
    }
    
    
    
    
    
}
