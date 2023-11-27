/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Interfaces.OptionPaneYesNoCallback;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class VehicleOutPanel extends JPanel {

    public VehicleOutPanel() {
       this.setLayout(new BorderLayout());
        
        EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Vehicle Number Plate");
        vehicleIdLabeledTFBtnPanel.getButton().setText("Submit");
        vehicleIdLabeledTFBtnPanel.getButton().setOptionPaneYesNoCallback(new OptionPaneYesNoCallback() {
            @Override
            public void onOptionYes() {
                System.out.println("CONFIRMED");
            }

            @Override
            public void onOptionNo() {
                // do nothing
            }
        });
        vehicleIdLabeledTFBtnPanel.setVisible(true);
        this.add(vehicleIdLabeledTFBtnPanel, BorderLayout.NORTH);
    }

//    public VehicleOutPanel() {
//        EPLabeledTextFieldPanel vehicleIdLabeledTextField = new EPLabeledTextFieldPanel();
//        vehicleIdLabeledTextField.getLabel().setText("Parking ID");
//
//        JButton submitBtn = new JButton();
//        submitBtn.setText("Submit");
//
//        this.setLayout(new BorderLayout());
//        this.add(vehicleIdLabeledTextField, BorderLayout.PAGE_START);
//        this.add(submitBtn, BorderLayout.PAGE_END);
//    }
}
