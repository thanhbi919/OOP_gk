package frontEnd;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class showMessageDialog{

    public static void showMessage(String message) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message);
    }
}