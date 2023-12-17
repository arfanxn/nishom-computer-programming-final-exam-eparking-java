/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Containers.Controllers;
import Controllers.ParkedVehicleController;
import Exceptions.NotFound;
import Exceptions.Validation;
import Models.ParkedVehicle;
import Requests.ParkedVehicle.LeaveRequest;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class LeaveVehiclePanel extends JPanel {

    EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel;

    public LeaveVehiclePanel() {
        this.setupViews();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        this.vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Vehicle Number Plate");
        vehicleIdLabeledTFBtnPanel.getButton().setText("Submit");
        vehicleIdLabeledTFBtnPanel.getButton().setOptionPaneYesListener((ActionEvent event) -> {
            try {
                LeaveRequest request = new LeaveRequest();
                request.setPlateNumber(vehicleIdLabeledTFBtnPanel.getTextField().getText());

                ParkedVehicleController pvc = Controllers.initParkedVehicle();
                ParkedVehicle parkedVehicle = pvc.leave(request);

                JOptionPane.showMessageDialog(
                        null,
                        "Vehicle with plate number: " + parkedVehicle.getPlateNumber() + " has been marked as left",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                this.vehicleIdLabeledTFBtnPanel.getTextField().setText(""); // resets the text
            } catch (Validation | NotFound e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
        vehicleIdLabeledTFBtnPanel.setVisible(true);
        this.add(vehicleIdLabeledTFBtnPanel, BorderLayout.NORTH);
    }
}
