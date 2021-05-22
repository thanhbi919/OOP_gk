package frontEnd;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import backEnd.FindAllPath;
import backEnd.StoreGraph;

class MenuListener implements ActionListener {
    public VerticalToolbar obj;
    public AppUI ui;

    public MenuListener(VerticalToolbar obj, AppUI ui) {
        this.obj = obj;
        this.ui = ui;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "open":
                open();
                break;

            case "saveText":
                try {
                    saveText();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                break;

            case "saveasText":
                saveasText();
                break;

            case "exportImg":
                try {
                    exportImg();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;

            case "exit":
                exit();
                break;

            case "setFont":
                setFont();
                break;

            case "setColor":
                setColor();
                break;

            case "help":
                help();
                break;

            case "about":
                about();
                break;

            case "run":
                run();
                break;
        }
    }

    private void open() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            StoreGraph.create(selectedFile.getAbsolutePath());

            if (StoreGraph.getGraph() == null)
                return;

            ui.loadGraph(StoreGraph.getGraph());
        }

    }

    private void saveText() throws IOException {
    }

    private void saveasText() {

    }

    private void exportImg() throws IOException {

        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int result = fileChooser.showSaveDialog(fileChooser);
        System.out.println(fileChooser.getSelectedFile().getName());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            BufferedImage image = new BufferedImage(ui.mainpanel.getWidth(), ui.mainpanel.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            ui.mainpanel.paint(g2);
            try {
                ImageIO.write(image, "png", new File(selectedFile.getAbsolutePath() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void setFont() {

    }

    private void setColor() {
        // StoreGraph.MainGraph.getNode("0").setAttribute("ui.class", "dekiru");
    }

    private void help() {

    }

    private void about() {

    }

    private void run() {
        String source = VerticalToolbar.getSD()[0];
        String destination = VerticalToolbar.getSD()[1];
        if (source.length() == 0 && destination.length() == 0) {
            String max = StoreGraph.MainGraph.getNode(0).getId(), min = max;
            System.out.println(max);
            for (Node node : StoreGraph.MainGraph) {
                if (max.compareToIgnoreCase(node.getId()) < 0)
                    max = node.getId();
                if (min.compareToIgnoreCase(node.getId()) > 0)
                    min = node.getId();
            }
            FindAllPath.printAllPaths(min, max);
        }
        if (StoreGraph.getGraph().getNode(source) != null && StoreGraph.getGraph().getNode(destination) != null)
            FindAllPath.printAllPaths(source, destination);

    }
}
