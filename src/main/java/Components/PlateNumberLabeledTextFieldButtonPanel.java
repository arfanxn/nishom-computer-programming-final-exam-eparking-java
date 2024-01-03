/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.border.Border;
import Utilities.UppercaseDocumentFilter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;

/**
 * PlateNumberLabeledTextFieldButtonPanel is a component which contains text field at the
 left side and button at the right side

 By default this extended JPanel has setVisible(false) So you have to make it
 visible every time you use it
 *
 * @author arfanxn
 */
public class PlateNumberLabeledTextFieldButtonPanel extends JPanel {

    private JLabel firstDashLabel;
    private JLabel secondDashLabel;
    private EPLabeledTextFieldPanel cityLabeledTextField;
    private EPLabeledTextFieldPanel numberLabeledTextField;
    private EPLabeledTextFieldPanel regionLabeledTextField;
    private EPButton button;

    public PlateNumberLabeledTextFieldButtonPanel() {
        this.setupViews();
    }

    private void setupViews() {
        super.setVisible(false);

        // instantiate
        this.firstDashLabel = new JLabel();
        this.secondDashLabel = new JLabel();
        this.cityLabeledTextField = new EPLabeledTextFieldPanel();
        this.numberLabeledTextField = new EPLabeledTextFieldPanel();
        this.regionLabeledTextField = new EPLabeledTextFieldPanel();
        this.button = new EPButton();

        // set the texts
        this.firstDashLabel.setText("-");
        this.secondDashLabel.setText("-");
        this.cityLabeledTextField.getLabel().setText("City");
        this.numberLabeledTextField.getLabel().setText("Number");
        this.regionLabeledTextField.getLabel().setText("Region");

        ((AbstractDocument) (this.cityLabeledTextField.getTextField().getDocument())).setDocumentFilter(new UppercaseDocumentFilter());
        ((AbstractDocument) (this.numberLabeledTextField.getTextField().getDocument())).setDocumentFilter(new UppercaseDocumentFilter());
        ((AbstractDocument) (this.regionLabeledTextField.getTextField().getDocument())).setDocumentFilter(new UppercaseDocumentFilter());

    }
    
    public void resetTextFieldTexts() {
        this.cityLabeledTextField.getTextField().setText("");
        this.numberLabeledTextField.getTextField().setText("");
        this.regionLabeledTextField.getTextField().setText("");
    }

    public EPLabeledTextFieldPanel getCityLabeledTextField() {
        return cityLabeledTextField;
    }

    public void setCityLabeledTextField(EPLabeledTextFieldPanel cityLabeledTextField) {
        this.cityLabeledTextField = cityLabeledTextField;
    }

    public EPLabeledTextFieldPanel getNumberLabeledTextField() {
        return numberLabeledTextField;
    }

    public void setNumberLabeledTextField(EPLabeledTextFieldPanel numberLabeledTextField) {
        this.numberLabeledTextField = numberLabeledTextField;
    }

    public EPLabeledTextFieldPanel getRegionLabeledTextField() {
        return regionLabeledTextField;
    }

    public void setRegionLabeledTextField(EPLabeledTextFieldPanel regionLabeledTextField) {
        this.regionLabeledTextField = regionLabeledTextField;
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

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(this.cityLabeledTextField, gbc);
        this.cityLabeledTextField.setVisible(true);
        
        Border dashLabelBorder = BorderFactory.createEmptyBorder(15, 5, 0, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.firstDashLabel.setBorder(dashLabelBorder);
        this.add(this.firstDashLabel, gbc);
        gbc.gridx = 3;
        this.secondDashLabel.setBorder(dashLabelBorder);
        this.add(this.secondDashLabel, gbc);
        this.secondDashLabel.setVisible(true);
        // resets gbc
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = 1;
        gbc.weighty = 0;

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(this.numberLabeledTextField, gbc);
        this.numberLabeledTextField.setVisible(true);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        this.add(this.regionLabeledTextField, gbc);
        this.regionLabeledTextField.setVisible(true);

        this.button.setSize(50, 25); // default size
        gbc.gridx = 5;
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
