/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Containers;

import Repositories.ParkedVehicleRepository;

/**
 *
 * @author arfanxn
 */
public class Repository {

    public static ParkedVehicleRepository initParkedVehicleRepository() {
        var databaseConfig = Configs.Database.getInstance();
        ParkedVehicleRepository repository = new ParkedVehicleRepository(databaseConfig);
        return repository;
    }

}
