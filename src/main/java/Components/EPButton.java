/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 * EPButton is a customized JButton, you can enable a confirmation dialog after
 * the button is clicked by set the optionPaneYesNoCallback property or disable
 * by keep it null
 *
 *
 * @author arfanxn
 */
public class EPButton extends JButton {

    private bool isOptionPaneAlreadySet;
    private ActionListener optionPaneYesListener;
    private ActionListener optionPaneNoListener;
    private String optionPaneMessage, optionPaneTitle;
    private Integer optionPaneType;

    public EPButton() {
        super.setVisible(false);
    }

    public String getOptionPaneMessage() {
        return this.optionPaneMessage != null ? this.optionPaneMessage : "Are u sure?";
    }

    public void setOptionPaneMessage(String message) {
        this.optionPaneMessage = message;
    }

    public String getOptionPaneTitle() {
        return this.optionPaneTitle != null ? this.optionPaneTitle : "Confirmation";
    }

    public void setOptionPaneTitle(String title) {
        this.optionPaneTitle = title;
    }

    public Integer getOptionPaneType() {
        return this.optionPaneType != null ? (int) this.optionPaneType : JOptionPane.YES_NO_OPTION;
    }

    public void setOptionPaneType(Integer optionType) {
        this.optionPaneType = optionType;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false) {
            return;
        }

        if (this.optionPaneYesListener != null && !isOptionPaneAlreadySet) {
            this.addActionListener((ActionEvent event) -> {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        this.getOptionPaneMessage(),
                        this.getOptionPaneTitle(),
                        (int) this.getOptionPaneType(),
                        JOptionPane.QUESTION_MESSAGE
                );
                if (option == JOptionPane.YES_OPTION) {
                    this.optionPaneYesListener.actionPerformed(event);
                } else if (option == JOptionPane.NO_OPTION && this.optionPaneNoListener != null) {
                    this.optionPaneNoListener.actionPerformed(event);
                }
            });
            
            this.isOptionPaneAlreadySet = true;
        }
    }

    public void setOptionPaneYesListener(ActionListener l) {
        this.optionPaneYesListener = l;
    }

    public void setOptionPaneNoListener(ActionListener l) {
        this.optionPaneNoListener = l;
    }
}
