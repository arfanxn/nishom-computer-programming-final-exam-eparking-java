package Components;

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arfanxn
 */
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class EPTabbedPane extends JTabbedPane {

    public EPTabbedPane() {
        EntryPanel entryPanel = new EntryPanel();
        entryPanel.setBackground(Color.DARK_GRAY);
        entryPanel.setLayout(new GridLayout(0, 1, 0, 0));

//        JScrollPane entryScrollPane = new JScrollPane();
//        entryScrollPane.add(entryPanel);
//        entryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        entryScrollPane.setBackground(Color.BLUE);
//        entryScrollPane.setLayout(new ScrollPaneLayout());
//        entryScrollPane.setVisible(true);

        OutPanel outPanel = new OutPanel();
        outPanel.setBackground(Color.GRAY);
        outPanel.setLayout(new GridLayout(0, 1));

        this.add("Entry", entryPanel);
        this.add("Out", outPanel);
    }

}
