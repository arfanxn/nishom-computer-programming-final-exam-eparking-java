/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Interfaces.EPConfirmButtonCallback;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author arfanxn
 */
public class EPConfirmButton extends JButton {

    private EPConfirmButtonCallback callback;
    private String message, title;
    private Integer optionType;

    public EPConfirmButton() {
        this.setText("Confirm");
    }

    public void setCallback(EPConfirmButtonCallback callback) {
        this.callback = callback;
        
        this.addActionListener((ActionEvent event) -> {
            
            int option = JOptionPane.showConfirmDialog(
                    null,
                    this.getMessage(),
                    this.getTitle(),
                    (int) this.getOptionType(), JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.YES_OPTION) {
                this.callback.onOptionYes();
            } else if (option == JOptionPane.NO_OPTION) {
                this.callback.onOptionNo();
            }
        });
    }

    public String getMessage() {
        return this.message != null ? this.message : "Are u sure?";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return this.title != null ? this.title : "Confirmation";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOptionType() {
        return this.optionType != null ? (int) this.optionType : JOptionPane.YES_NO_OPTION;
    }

    public void setOptionType(Integer optionType) {
        this.optionType = optionType;
    }

}
