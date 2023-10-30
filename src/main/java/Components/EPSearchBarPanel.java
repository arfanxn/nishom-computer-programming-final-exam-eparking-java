/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author arfanxn
 */
public class EPSearchBarPanel extends JPanel{

    JButton button;
    JTextField textField;
    
    public EPSearchBarPanel() {
        this.button = new JButton();
        this.button.setText("Search");
        this.button.setSize(50, 25); // default size

        this.textField = new JTextField();
        this.textField.setText("");
        this.textField.setSize(100, 25); // default size

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        this.add(this.textField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        this.add(this.button, gbc);
        
    }
    
}
