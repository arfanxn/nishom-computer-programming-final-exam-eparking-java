/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.JTable;
import java.util.List;
import Models.ParkedVehicle;
import javax.swing.table.DefaultTableModel;

/*
import Containers.Controllers;
import Controllers.ParkedVehicleController;
import Exceptions.Validation;
import Requests.ParkedVehicle.UpdatePlateNumberRequest;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
 */

/**
 *
 * @author arfanxn
 */
public class ParkedVehicleTable extends JTable {

    private List<ParkedVehicle> rows;

    public ParkedVehicleTable() {
    }

    public void setRows(List<ParkedVehicle> rows) {
        this.rows = rows;
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                /*
                // Make only the second columnIndex (Plate number) editable
                return column == 1;
                 */
                // Make all cell uneditable
                return false;
            }
        };
        tableModel.setColumnIdentifiers((new ParkedVehicle().getColumnNames()));
        for (ParkedVehicle parkedVehicle : this.rows) {
            tableModel.addRow(parkedVehicle.getValues());
        }
        /*
        tableModel.addTableModelListener((TableModelEvent event) -> {
            if (event.getType() == TableModelEvent.UPDATE) {
                try {
                    int rowIndex = event.getFirstRow();
                    int columnIndex = event.getColumn();

                    // Ensure the row and column are within valid bounds
                    if (rowIndex >= 0 && rowIndex < tableModel.getRowCount() && columnIndex >= 0 && columnIndex < tableModel.getColumnCount()) {
                    } else {
                        return;
                    }

                    String oldPlateNumber = this.rows.get(rowIndex).getPlateNumber();
                    String newPlateNumber = String.valueOf(tableModel.getValueAt(rowIndex, columnIndex));

                    UpdatePlateNumberRequest request = new UpdatePlateNumberRequest();
                    request.setPlateNumber(newPlateNumber);

                    int option = JOptionPane.showConfirmDialog(
                            null,
                            "Edit " + oldPlateNumber + " to " + newPlateNumber,
                            "Confirm edit",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (option == JOptionPane.YES_OPTION) {
                        ParkedVehicleController pvc = Controllers.initParkedVehicle();
                        ParkedVehicle parkedVehicle = pvc.updatePlateNumber(request);
                        this.rows.set(rowIndex, parkedVehicle);
                    } else if (option == JOptionPane.NO_OPTION) {
                        tableModel.setValueAt(oldPlateNumber, rowIndex, columnIndex);
                    }

                } catch (SQLException e) {
                    System.out.println(e);
                } catch (Validation e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(
                            null,
                            e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
         */
        this.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

}
