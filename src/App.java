import javax.swing.SwingUtilities;

import frontEnd.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                appUI ex = new appUI(null);
                ex.setVisible(true);
            }
        });
    }
}
