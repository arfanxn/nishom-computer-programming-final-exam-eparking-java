/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Containers.Controllers;
import Containers.Repositories;
import Controllers.ParkedVehicleController;
import Interfaces.OptionPaneYesNoCallback;
import Models.ParkedVehicle;
import Repositories.ParkedVehicleRepository;
import Requests.ParkedVehicle.EnterRequest;
import Requests.ParkedVehicle.LeaveRequest;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class VehicleOutPanel extends JPanel {

    public VehicleOutPanel() {
        this.setupViews();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Vehicle Number Plate");
        vehicleIdLabeledTFBtnPanel.getButton().setText("Submit");
        vehicleIdLabeledTFBtnPanel.getButton().setOptionPaneYesNoCallback(new OptionPaneYesNoCallback() {
            @Override
            public void onOptionYes() {
                try {
                    LeaveRequest request = new LeaveRequest();
                    request.setPlateNumber(vehicleIdLabeledTFBtnPanel.getTextField().getText());

                    ParkedVehicleController pvc = Controllers.initParkedVehicle();
                    ParkedVehicle parkedVehicle = pvc.leave(request);

                    JOptionPane.showMessageDialog(
                            null,
                            "Success",
                            "Vehicle with plate number: " + parkedVehicle.getPlateNumber() + " has been marked as left",
                            JOptionPane.INFORMATION_MESSAGE
                );
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
