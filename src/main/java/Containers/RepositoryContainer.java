/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Containers;

import Repositories.ParkedVehicleRepository;
import Models.ParkedVehicle;

/**
 *
 * @author arfanxn
 */
public class RepositoryContainer {
    
    public static ParkedVehicleRepository InitializeParkedVehicleRepository() {
        ParkedVehicle model = new ParkedVehicle();
        var databaseConfig = Configs.Database.getInstance();
        ParkedVehicleRepository repository = new ParkedVehicleRepository(databaseConfig, model);
        return repository;
    }
    
}
