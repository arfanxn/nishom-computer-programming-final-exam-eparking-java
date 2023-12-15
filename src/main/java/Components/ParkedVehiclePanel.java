/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Models.ParkedVehicle;
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

    public ParkedVehicleTable table;
    public JScrollPane scrollPane;

    public ParkedVehiclePanel() {
        this.setupViews();
        this.setupEvents();
    }

    public void setupViews() {
        try {
            this.setLayout(new BorderLayout());

            EPLabeledTextFieldButtonPanel searchBarLabeledTFBtnPanel = new EPLabeledTextFieldButtonPanel();
            searchBarLabeledTFBtnPanel.getButton().setText("Search");
            searchBarLabeledTFBtnPanel.setVisible(true);
            this.add(searchBarLabeledTFBtnPanel, BorderLayout.PAGE_START);

            var pvr = Containers.Repository.initParkedVehicleRepository();
            pvr.getQueryBuilder().setLimit(1000);
            pvr.get();
            List<ParkedVehicle> parkedVehicles = pvr.getCollection();

            this.table = new ParkedVehicleTable();
            this.table.setRows(parkedVehicles);

            this.scrollPane = new JScrollPane(this.table);
            this.add(scrollPane, BorderLayout.CENTER);

            pvr.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Add default events
    public final void setupEvents() {
        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                System.out.println("ancestorAdded");
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                System.out.println("ancestorRemoved");
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

}
