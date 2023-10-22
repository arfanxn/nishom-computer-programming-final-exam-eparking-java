/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class OutPanel extends JPanel {

    public OutPanel() {
        EPLabeledTextField vehicleIdLabeledTextField = new EPLabeledTextField();
        vehicleIdLabeledTextField.label.setText("id");
        vehicleIdLabeledTextField.textField.setText("id");

        EPLabeledTextField[] labeledTextFields = {
            vehicleIdLabeledTextField,};
        for (EPLabeledTextField labeledTextField : labeledTextFields) {
            labeledTextField.setBounds(0, 0, 500, 100);
            this.add(labeledTextField);
        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

}
