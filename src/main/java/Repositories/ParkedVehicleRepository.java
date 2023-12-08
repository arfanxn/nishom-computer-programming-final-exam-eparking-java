/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Configs.Database;
import Interfaces.Model;
import Interfaces.ModelCollection;


/**
 *
 * @author arfanxn
 */
public class ParkedVehicleRepository extends Repository {

    public ParkedVehicleRepository(Database databaseConfig, Model model, ModelCollection modelCollection) {
        super(databaseConfig, model, modelCollection);
    }

}
