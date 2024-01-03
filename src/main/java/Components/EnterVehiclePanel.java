/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import Containers.Controllers;
import Controllers.ParkedVehicleController;
import Models.ParkedVehicle;
import Forms.ParkedVehicle.PlateNumberForm;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author arfanxn
 */
public class EnterVehiclePanel extends JPanel {

    PlateNumberLabeledTextFieldButtonPanel pnltfbp;

    public EnterVehiclePanel() {
        this.setupViews();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        pnltfbp = new PlateNumberLabeledTextFieldButtonPanel();
        pnltfbp.getButton().setText("Submit");
        pnltfbp.getButton().setOptionPaneYesListener((ActionEvent event) -> {
            try {
                PlateNumberForm form = new PlateNumberForm();
                form.setCity(pnltfbp.getCityLabeledTextField().getTextField().getText());
                form.setNumber(pnltfbp.getNumberLabeledTextField().getTextField().getText());
                form.setRegion(pnltfbp.getRegionLabeledTextField().getTextField().getText());

                ParkedVehicleController pvc = Controllers.initParkedVehicle();
                ParkedVehicle parkedVehicle = pvc.enter(form);

                JOptionPane.showMessageDialog(
                        null,
                        "Vehicle with plate number: " + parkedVehicle.getPlateNumber() + " has been marked as entered",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                this.pnltfbp.resetTextFieldTexts(); // resets the text
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
        });
        pnltfbp.setVisible(true);
        this.add(pnltfbp, BorderLayout.NORTH);
    }

}
