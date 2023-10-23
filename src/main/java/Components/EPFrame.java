package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author arfanxn
 */
public class EPFrame extends JFrame {

    public EPFrame() throws HeadlessException {
        // Set the icon of the frame
        ImageIcon imgIcon = new ImageIcon("src/assets/images/icon.png");
        this.setIconImage(imgIcon.getImage());

        // Set the frame
        this.setTitle("E-Parking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 255, 255)); // white background
        this.setResizable(true);
        this.setLayout(new BorderLayout());
    }
}
