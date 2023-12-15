
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

    private static final int FRAME_WIDTH = 750, FRAME_HEIGHT = 500;

    public static void main(String[] args) {
        // load and configure the env 
        Configs.ENV.getInstance().loadAndConfigure();

        // instantiate frame
        EPFrame frame = new EPFrame();

        // instantiate tabbed pane
        EPTabbedPane tabbedPane = new EPTabbedPane();

        // add component(s) to frame
        frame.getContentPane().add(tabbedPane);

        // configure frame
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}
