package frontEnd;

import java.awt.*;

import javax.swing.*;

import org.graphstream.graph.Graph;

public class appUI extends JFrame {
    private JPanel graphP;

    public appUI(Graph graph) {
        initappUI(graph);
    }

    private final void initappUI(Graph graph) {

        // Create menu bar
        setJMenuBar(new menuBar());

        // Create vertical bar
        add(new verticalToolbar(), BorderLayout.WEST);

        // Create graph panel
        if (graphP != null)
            remove(graphP);
        graphP = new graphPanel(null);
        add(graphP);

        setSize(1000, 800);
        setTitle("OOP GK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
