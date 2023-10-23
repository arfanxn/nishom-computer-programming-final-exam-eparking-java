
import Components.EPTabbedPane;
import Components.EPFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change frame license
 */
/**
 *
 * @author arfanxn
 */
public class Main {
    
    private static final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500;

    public static void main(String[] args) {
        EPFrame frame = new EPFrame();

        EPTabbedPane tabbedPane = new EPTabbedPane();
        tabbedPane.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().add(tabbedPane);

        frame.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}
