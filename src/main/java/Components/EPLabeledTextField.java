/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author arfanxn
 */
public class EPLabeledTextField extends JPanel {

    public JTextField textField;
    public JLabel label;

    public EPLabeledTextField() {
        this.label = new JLabel();
        this.label.setText("Changeable label");
        this.label.setLayout(null); // temporary

        this.textField = new JTextField();
        this.textField.setText("Changeable textfield placeholder"); // temporary
        this.textField.setLayout(null); // temporary

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.label);
        this.add(this.textField);
    }

}
