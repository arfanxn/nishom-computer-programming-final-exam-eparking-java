/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import Interfaces.OptionPaneYesNoCallback;
import Repositories.ParkedVehicleRepository;
import Containers.Repository;
import Models.ParkedVehicle;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author arfanxn
 */
public class VehicleEntryPanel extends JPanel {

    public VehicleEntryPanel() {
        this.setupViews();
    }
    
    private void setupViews() {
        this.setLayout(new BorderLayout());

        EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Plate Number");
        vehicleIdLabeledTFBtnPanel.getButton().setText("Submit");
        vehicleIdLabeledTFBtnPanel.getButton().setOptionPaneYesNoCallback(new OptionPaneYesNoCallback() {
            @Override
            public void onOptionYes() {
                try {
                    String plateNumber = vehicleIdLabeledTFBtnPanel.getTextField().getText();
                    if (plateNumber.length() < 9 || plateNumber.length() > 12) {
                        throw new Exceptions.Validation("Invalid plate number");
                    }
                    
                    ParkedVehicleRepository pvr = Repository.initParkedVehicleRepository();
                    ParkedVehicle parkedVehicle = new ParkedVehicle();
                    parkedVehicle.setPlateNumber(plateNumber);
                    pvr.create(parkedVehicle);
                    
                    JOptionPane.showMessageDialog(
                            null,
                            "Success",
                            "Vehicle with plate number: " + plateNumber + " has been marked as entered",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    System.out.println(e);
                } catch (Exceptions.Validation e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(
                            null,
                            e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void onOptionNo() {
                // do nothing
            }
        });
        vehicleIdLabeledTFBtnPanel.setVisible(true);
        this.add(vehicleIdLabeledTFBtnPanel, BorderLayout.NORTH);
    }

}
