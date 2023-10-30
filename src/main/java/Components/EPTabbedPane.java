package Components;

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author arfanxn
 */

import javax.swing.*;

public class EPTabbedPane extends JTabbedPane {

    public EPTabbedPane() {
        VehicleListPanel vehicleListPanel = new VehicleListPanel();
        VehicleEntryPanel vehicleEntryPanel = new VehicleEntryPanel();
        VehicleOutPanel vehicleOutPanel = new VehicleOutPanel();

        this.add("List", vehicleListPanel);
        this.add("Entry", vehicleEntryPanel);
        this.add("Out", vehicleOutPanel);
    }

}
