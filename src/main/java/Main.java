
import Components.EPTabbedPane;
import Components.EPFrame;
import Components.EPLabeledTextField;
import Components.EntryPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change frame license
 */
/**
 *
 * @author arfanxn
 */
public class Main {

    public static void main(String[] args) {
        int width = 500, height = 500;

        EPFrame frame = new EPFrame();

        EPTabbedPane tabbedPane = new EPTabbedPane();
        tabbedPane.setBounds(0, 0, width, height);
        frame.getContentPane().add(tabbedPane);

//        EPLabeledTextField ltf = new EPLabeledTextField();
//        ltf.setBounds(0, 0, width, 111);
//        frame.add(ltf);

//        EntryPanel entryPanel = new EntryPanel();
//        entryPanel.setBounds(0, 0, 100, 100);
//        entryPanel.setLayout(null); // temporary
//        frame.setLayout(new BorderLayout());
//        frame.add(entryPanel, BorderLayout.CENTER);
        

        frame.setBounds(0, 0, width, height);
        // frame.setLayout(null); temporaryly disable
        frame.setVisible(true);
    }
}
