/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author arfanxn
 */
public class EPLabeledTextFieldPanel extends JPanel {

    public JTextField textField;
    public JLabel label;

    public EPLabeledTextFieldPanel() {
        this.label = new JLabel();
        this.label.setText("Label");
        this.label.setSize(100, 25); // default size

        this.textField = new JTextField();
        this.textField.setText("");
        this.textField.setSize(100, 25); // default size

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(this.label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.textField, gbc);
    }

}
