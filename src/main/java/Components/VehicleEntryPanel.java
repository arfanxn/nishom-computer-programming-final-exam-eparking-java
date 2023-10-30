/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Interfaces.EPConfirmButtonCallback;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class VehicleEntryPanel extends JPanel {

    public VehicleEntryPanel() {
        EPLabeledTextFieldPanel vehicleIdLabeledTextField = new EPLabeledTextFieldPanel();
        vehicleIdLabeledTextField.label.setText("Vehicle Number Plate");

        EPConfirmButton confirmButton = new EPConfirmButton();
        confirmButton.setText("Submit");
        confirmButton.setCallback(new EPConfirmButtonCallback() {
            @Override
            public void onOptionYes() {
                System.out.println("CONFIRMED");
            }

            @Override
            public void onOptionNo() {
                // do nothing
            }
        });

        this.setLayout(new BorderLayout());
        this.add(vehicleIdLabeledTextField, BorderLayout.PAGE_START);
        this.add(confirmButton, BorderLayout.PAGE_END);
    }

}
