package frontEnd;

import java.awt.*;

import javax.swing.*;
import org.graphstream.graph.Graph;

import backEnd.StoreGraph;

public class AppUI extends JFrame {
    public static JPanel mainpanel;

    public AppUI() {
        initappUI();
        StoreGraph.create("graph.txt");
        loadGraph(StoreGraph.getGraph());

    }

    private final void initappUI() {
        MenuListener menuListener = new MenuListener(null, this);
        // Create menu bar
        MenuBar addMenuBar = new MenuBar(menuListener);
        setJMenuBar(addMenuBar);

        // Create vertical bar
        VerticalToolbar verticalToolbar = new VerticalToolbar(menuListener);
        menuListener.obj = verticalToolbar;
        add(verticalToolbar, BorderLayout.WEST);
        setSize(1000, 800);
        setTitle("OOP GK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void loadGraph(Graph graph) {
        if (mainpanel != null)
            remove(mainpanel);
        mainpanel = GraphPanel.create(graph);
        add(mainpanel);
        revalidate();
    }

    public void test(JPanel panel) {
        add(mainpanel);
    }
}
