/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * EPLabeledTextFieldButtonPanel is a component which contains text field at the
 * left side and button at the right side
 *
 * By default this extended JPanel has setVisible(false) So you have to make it
 * visible every time you use it
 *
 * @author arfanxn
 */
public class EPLabeledTextFieldButtonPanel extends JPanel {

    private EPLabeledTextFieldPanel labeledTextFieldPanel;
    private EPButton button;

    public EPLabeledTextFieldButtonPanel() {
        super.setVisible(false);
        this.labeledTextFieldPanel = new EPLabeledTextFieldPanel();
        this.button = new EPButton();
    }

    public EPLabeledTextFieldPanel getLabeledTextFieldPanel() {
        return labeledTextFieldPanel;
    }

    public void setLabeledTextFieldPanel(EPLabeledTextFieldPanel labeledTextFieldPanel) {
        this.labeledTextFieldPanel = labeledTextFieldPanel;
    }

    public JLabel getLabel() {
        return this.getLabeledTextFieldPanel().getLabel();
    }

    public void setLabel(JLabel label) {
        this.getLabeledTextFieldPanel().setLabel(label);
    }

    public JTextField getTextField() {
        return this.getLabeledTextFieldPanel().getTextField();
    }

    public void setTextField(JTextField textField) {
        this.getLabeledTextFieldPanel().setTextField(textField);
    }

    public EPButton getButton() {
        return this.button;
    }

    public void setButton(EPButton button) {
        this.button = button;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false) {
            return;
        }

        // Add text field on enter buttton clicked event lisnter
        this.getTextField().addActionListener((ActionEvent e) -> {
            getButton().doClick(); // click the button after enter key cliked
        });

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(this.labeledTextFieldPanel, gbc);
        this.labeledTextFieldPanel.setVisible(true);

        this.button.setSize(50, 25); // default size
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(
                new EPBorderLayoutPanel(this.button, EPBorderLayoutPanel.SOUTH),
                gbc);
        this.button.setVisible(true);
    }

}
