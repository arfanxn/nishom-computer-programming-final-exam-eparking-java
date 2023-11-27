/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Interfaces.Model;
import Interfaces.Repository;
import Interfaces.View;
import Models.ParkedVehicle;
import Repositories.ParkedVehicleRepository;
import Views.ParkedVehicleView;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleController extends Controller<Model, Repository, View> {

    public ParkedVehicleController(Model model, Repository repository, View view) {
        super(model, repository, view);
    }
    
    /**
     *
     */
    public ParkedVehicleController() {
        ParkedVehicle model = new ParkedVehicle();
        ParkedVehicleRepository repository = new ParkedVehicleRepository();
        ParkedVehicleView view = new ParkedVehicleView();
        this.setModel(model);
        this.setRepository(repository);
        this.setView(view);
    }

    public void index() {
        
    }

}
