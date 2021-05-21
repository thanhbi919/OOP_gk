package frontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

class MenuListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "open":
                open();
            case "saveText":
                saveText();
            case "saveasText":
                saveasText();
            case "exportImg":
                exportImg();
            case "exit":
                exit();
            case "setFont":
                setFont();
            case "setColor":
                setColor();
            case "help":
                help();
            case "about":
                about();

        }
    }

    private void open() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    private void saveText() {

    }

    private void saveasText() {

    }

    private void exportImg() {

    }

    private void exit() {

    }

    private void setFont() {

    }

    private void setColor() {

    }

    private void help() {

    }

    private void about() {

    }
}