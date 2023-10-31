/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Interfaces.OptionPaneYesNoCallback;

/**
 *
 * @author arfanxn
 */
public class EPButton extends JButton {

    private OptionPaneYesNoCallback optionPaneYesNoCallback;
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

    public void setOptionPaneYesNoCallback(OptionPaneYesNoCallback callback) {
        this.optionPaneYesNoCallback = callback;
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == false) {
            return;
        }

        if (this.optionPaneYesNoCallback != null) {
            this.addActionListener((ActionEvent event) -> {
            int option = JOptionPane.showConfirmDialog(
                    null,
                    this.getOptionPaneMessage(),
                    this.getOptionPaneTitle(),
                    (int) this.getOptionPaneType(),
                    JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.YES_OPTION) {
                this.optionPaneYesNoCallback.onOptionYes();
            } else if (option == JOptionPane.NO_OPTION) {
                this.optionPaneYesNoCallback.onOptionNo();
            }
        });
        }
    }
}
