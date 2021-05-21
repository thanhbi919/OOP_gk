import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.graphstream.graph.Graph;

import backEnd.*;
import frontEnd.appUI;

public class App {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                appUI app = new appUI();
            }
        });
    }
}
