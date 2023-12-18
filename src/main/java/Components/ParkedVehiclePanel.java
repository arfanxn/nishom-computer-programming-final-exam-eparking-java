/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Containers.Controllers;
import Exceptions.Validation;
import java.awt.event.ActionEvent;
import Models.ParkedVehicle;
import Requests.ParkedVehicle.SearchByPlateNumberRequest;
import Utilities.UppercaseDocumentFilter;
import java.awt.BorderLayout;
import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author arfanxn
 */
public final class ParkedVehiclePanel extends JPanel {

    public ParkedVehicleTable table;
    public JScrollPane scrollPane;

    public ParkedVehiclePanel() {
        this.setupViews();
        this.setupEvents();
    }

    private void setupViews() {
        this.setLayout(new BorderLayout());

        EPLabeledTextFieldButtonPanel searchBarLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
        ((AbstractDocument) searchBarLabeledTFBtnPanel.getTextField().getDocument())
                .setDocumentFilter(new UppercaseDocumentFilter());
        searchBarLabeledTFBtnPanel.getButton().setText("Search");
        searchBarLabeledTFBtnPanel.getButton().addActionListener((ActionEvent event) -> {
            try {
                SearchByPlateNumberRequest request = new SearchByPlateNumberRequest();
                request.setPlateNumber(searchBarLabeledTFBtnPanel.getTextField().getText());

                var pvc = Controllers.initParkedVehicle();
                List<ParkedVehicle> parkedVehicles = pvc.searchByPlateNumber(request);
                table.setRows(parkedVehicles);
            } catch (Validation e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
        searchBarLabeledTFBtnPanel.setVisible(true);
        this.add(searchBarLabeledTFBtnPanel, BorderLayout.PAGE_START);

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
