import javax.swing.SwingUtilities;

import frontEnd.AppUI;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // System.out.println(System.getProperty("user.dir"));
                new AppUI();
            }
        });
    }
}
