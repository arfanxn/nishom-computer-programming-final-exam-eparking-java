/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Containers;

import Repositories.ParkedVehicleRepository;
import Models.ParkedVehicle;
import Models.ParkedVehicleCollection;

/**
 *
 * @author arfanxn
 */
public class Repository {
    
    public static ParkedVehicleRepository initializeParkedVehicleRepository() {
        var model = new ParkedVehicle();
        var modelCollection = new ParkedVehicleCollection();
        var databaseConfig = Configs.Database.getInstance();
        ParkedVehicleRepository repository = new ParkedVehicleRepository(databaseConfig, model, modelCollection);
        return repository;
    }
    
}
