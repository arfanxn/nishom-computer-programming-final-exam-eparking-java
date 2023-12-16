/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.JTable;
import java.util.List;
import Models.ParkedVehicle;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleTable extends JTable {

    private List<ParkedVehicle> rows;

    public ParkedVehicleTable() {
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
        tableModel.setColumnIdentifiers((new ParkedVehicle().getColumnNames()));
        this.setModel(tableModel);
    }

    public void replaceRows(List<ParkedVehicle> rows) {
        this.removeRows();
        this.setRows(rows);
    }

    public void setRows(List<ParkedVehicle> rows) {
        this.rows = rows;
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
        int index = 0;
        for (ParkedVehicle parkedVehicle : this.rows) {
            tableModel.insertRow(index, parkedVehicle.getValues());
            index++;
        }
        this.setModel(tableModel);
    }

    public void removeRows() {
        DefaultTableModel tableModel = (DefaultTableModel) this.getModel();
        for (int i = (tableModel.getRowCount() - 1); i >= 0; i--) {
            tableModel.removeRow(i);
        }
        this.rows = new ArrayList<>();
        this.setModel(tableModel);
    }

}
