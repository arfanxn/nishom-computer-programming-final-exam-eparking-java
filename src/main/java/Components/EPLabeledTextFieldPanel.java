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
 * By default this extended JPanel has setVisible(false)
 * So you have to make it visible every time you use it
 * 
 * @author arfanxn
 */
public class EPLabeledTextFieldPanel extends JPanel {

    private JTextField textField;
    private JLabel label;

    public EPLabeledTextFieldPanel() {
        super.setVisible(false);
        this.label = new JLabel();
        this.textField = new JTextField();
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false) {
            return;
        }

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        if (label.getText() != null) {
            this.label.setSize(100, 25); // default size
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.add(this.label, gbc);
        }

        this.textField.setText("");
        this.textField.setSize(100, 25); // default size
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(this.textField, gbc);
    }

}
