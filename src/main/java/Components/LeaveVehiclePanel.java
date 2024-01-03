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
import Forms.ParkedVehicle.PlateNumberForm;
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

    PlateNumberLabeledTextFieldButtonPanel pnltfbp;

    public LeaveVehiclePanel() {
        this.setupViews();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        this.pnltfbp = new PlateNumberLabeledTextFieldButtonPanel();
        pnltfbp.getButton().setText("Submit");
        pnltfbp.getButton().setOptionPaneYesListener((ActionEvent event) -> {
            try {
                PlateNumberForm form = new PlateNumberForm();
                form.setCity(pnltfbp.getCityLabeledTextField().getTextField().getText());
                form.setNumber(pnltfbp.getNumberLabeledTextField().getTextField().getText());
                form.setRegion(pnltfbp.getRegionLabeledTextField().getTextField().getText());

                ParkedVehicleController pvc = Controllers.initParkedVehicle();
                ParkedVehicle parkedVehicle = pvc.leave(form);

                JOptionPane.showMessageDialog(
                        null,
                        "Vehicle with plate number: " + parkedVehicle.getPlateNumber() + " has been marked as left",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                this.pnltfbp.resetTextFieldTexts();
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
        pnltfbp.setVisible(true);
        this.add(pnltfbp, BorderLayout.NORTH);
    }
}
