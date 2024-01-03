/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Containers.Controllers;
import java.awt.event.ActionEvent;
import Models.ParkedVehicle;
import Forms.ParkedVehicle.PlateNumberForm;
import java.awt.BorderLayout;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author arfanxn
 */
public final class ParkedVehiclePanel extends JPanel {

    public PlateNumberLabeledTextFieldButtonPanel pnltfbp;
    public ParkedVehicleTable table;
    public JScrollPane scrollPane;

    public ParkedVehiclePanel() {
        this.setupViews();
        this.setupEvents();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        pnltfbp = new PlateNumberLabeledTextFieldButtonPanel();
        pnltfbp.getButton().setText("Search");
        pnltfbp.getButton().addActionListener((ActionEvent event) -> {
            try {
                PlateNumberForm form = new PlateNumberForm();
                form.setCity(pnltfbp.getCityLabeledTextField().getTextField().getText());
                form.setNumber(pnltfbp.getNumberLabeledTextField().getTextField().getText());
                form.setRegion(pnltfbp.getRegionLabeledTextField().getTextField().getText());

                var pvc = Controllers.initParkedVehicle();
                List<ParkedVehicle> parkedVehicles = pvc.searchByPlateNumber(form);
                table.setRows(parkedVehicles);
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
        pnltfbp.setVisible(true);
        this.add(pnltfbp, BorderLayout.PAGE_START);

        this.table = new ParkedVehicleTable();
        this.scrollPane = new JScrollPane(this.table);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    // setupEvents 
    private void setupEvents() {
        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                try {
                    var pvc = Controllers.initParkedVehicle();
                    List<ParkedVehicle> parkedVehicles = pvc.all();
                    table.setRows(parkedVehicles);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

}
