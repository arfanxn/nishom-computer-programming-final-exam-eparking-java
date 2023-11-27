/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Components.VehicleEntryPanel;
import Components.VehicleListPanel;
import Components.VehicleOutPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleView extends JTabbedPane implements Interfaces.View {
    
    public ParkedVehicleView() {
        VehicleListPanel vehicleListPanel = new VehicleListPanel();
        VehicleEntryPanel vehicleEntryPanel = new VehicleEntryPanel();
        VehicleOutPanel vehicleOutPanel = new VehicleOutPanel();

        this.add("List", vehicleListPanel);
        this.add("Entry", vehicleEntryPanel);
        this.add("Out", vehicleOutPanel);
    }
    
}
