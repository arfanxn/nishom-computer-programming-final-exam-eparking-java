/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import Interfaces.OptionPaneYesNoCallback;
import Containers.Controllers;
import Controllers.ParkedVehicleController;
import Models.ParkedVehicle;
import Requests.ParkedVehicle.EnterRequest;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author arfanxn
 */
public class VehicleEntryPanel extends JPanel {
    
    EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel;

    public VehicleEntryPanel() {
        this.setupViews();
    }
    
    private void setupViews() {
        this.setLayout(new BorderLayout());

        vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Plate Number");
        vehicleIdLabeledTFBtnPanel.getButton().setText("Submit");
        vehicleIdLabeledTFBtnPanel.getButton().setOptionPaneYesNoCallback(new OptionPaneYesNoCallback() {
            @Override
            public void onOptionYes() {
                try {                  
                    EnterRequest request = new EnterRequest();
                    request.setPlateNumber(vehicleIdLabeledTFBtnPanel.getTextField().getText());

                    ParkedVehicleController pvc = Controllers.initParkedVehicle();
                    ParkedVehicle parkedVehicle = pvc.enter(request);

                    JOptionPane.showMessageDialog(
                            null,
                            "Success",
                            "Vehicle with plate number: " + parkedVehicle.getPlateNumber() + " has been marked as entered",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    System.out.println(e);
                } catch (Exceptions.Validation e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(
                            null,
                            e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void onOptionNo() {
                // do nothing
            }
        });
        vehicleIdLabeledTFBtnPanel.setVisible(true);
        this.add(vehicleIdLabeledTFBtnPanel, BorderLayout.NORTH);
    }

}
