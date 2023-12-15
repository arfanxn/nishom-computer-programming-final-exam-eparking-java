/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Containers.Repository;
import Interfaces.OptionPaneYesNoCallback;
import Models.ParkedVehicle;
import Repositories.ParkedVehicleRepository;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author arfanxn
 */
public class VehicleOutPanel extends JPanel {

    public VehicleOutPanel() {
        this.setupViews();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        EPLabeledTextFieldButtonPanel vehicleIdLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        vehicleIdLabeledTFBtnPanel.getLabel().setText("Vehicle Number Plate");
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
                    pvr.getQueryBuilder().addWhere("plate_number", "=", plateNumber);
                    pvr.getPreparedStatement().setString(1, plateNumber);
                    pvr.get();
                    parkedVehicle = pvr.getCollection().get(0);
                    pvr.update(parkedVehicle);
                    if (pvr.getTotalAffectedRows() == 0) {
                        throw new SQLException("Update failed");
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Success",
                            "Vehicle with plate number: " + plateNumber + " has been marked as left",
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
