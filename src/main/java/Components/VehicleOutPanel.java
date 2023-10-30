/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class VehicleOutPanel extends JPanel {

    public VehicleOutPanel() {
        EPLabeledTextFieldPanel vehicleIdLabeledTextField = new EPLabeledTextFieldPanel();
        vehicleIdLabeledTextField.label.setText("Parking ID");

        EPButton submitBtn = new EPButton();
        submitBtn.setText("Submit");

        this.setLayout(new BorderLayout());
        this.add(vehicleIdLabeledTextField, BorderLayout.PAGE_START);
        this.add(submitBtn, BorderLayout.PAGE_END);
    }

}
