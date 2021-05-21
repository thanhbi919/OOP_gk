package frontEnd;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import org.graphstream.graph.Graph;

import frontEnd.MenuListener;

public class appUI extends JFrame {
    JPanel mainpanel;

    public appUI() {
        initappUI();
    }

    private final void initappUI() {
        MenuListener menuListener = new MenuListener(null, this);
        // Create menu bar
        menuBar addMenuBar = new menuBar(menuListener);
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
        mainpanel = graphPanel.create(graph);
        add(mainpanel);
        revalidate();
    }
}
