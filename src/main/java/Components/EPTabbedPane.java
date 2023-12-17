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
        ParkedVehiclePanel parkedVehiclePanel = new ParkedVehiclePanel();
        EnterVehiclePanel enterVehiclePanel = new EnterVehiclePanel();
        LeaveVehiclePanel vehicleLeavePanel = new LeaveVehiclePanel();

        this.add("List", parkedVehiclePanel);
        this.add("Enter", enterVehiclePanel);
        this.add("Leave", vehicleLeavePanel);
    }

}
