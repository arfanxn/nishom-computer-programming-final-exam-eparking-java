/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author arfanxn
 */
public class EntryPanel extends JPanel {

    public EntryPanel() {
        EPLabeledTextField vehicleIdLabeledTextField = new EPLabeledTextField();
        vehicleIdLabeledTextField.label.setText("Vehicle id");
        vehicleIdLabeledTextField.textField.setText("Vehicle id");

        EPLabeledTextField vehicleColorLabeledTextField = new EPLabeledTextField();
        vehicleColorLabeledTextField.label.setText("Vehicle color");
        vehicleColorLabeledTextField.textField.setText("Vehicle color");

        EPLabeledTextField vehicleTypeLabeledTextField = new EPLabeledTextField();
        vehicleTypeLabeledTextField.label.setText("Vehicle type");
        vehicleTypeLabeledTextField.textField.setText("Vehicle type");

        EPLabeledTextField vehicleOwnerIdLabeledTextField = new EPLabeledTextField();
        vehicleOwnerIdLabeledTextField.label.setText("Vehicle owner id");
        vehicleOwnerIdLabeledTextField.textField.setText("Vehicle owner id");

        EPLabeledTextField[] labeledTextFields = {
            vehicleIdLabeledTextField,
            vehicleColorLabeledTextField,
            vehicleTypeLabeledTextField,
            vehicleOwnerIdLabeledTextField,};
        for (EPLabeledTextField labeledTextField : labeledTextFields) {
            labeledTextField.setLayout(new GridLayout(0, 1));
            this.add(labeledTextField);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

}
