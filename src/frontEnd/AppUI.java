package frontEnd;

import java.awt.*;

import javax.swing.*;

import App.App;

public class AppUI extends JFrame {
    public AppUI(App app) {
        initappUI(app);
    }

    private final void initappUI(App app) {
        MenuListener menuListener = new MenuListener(null, app);
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
}
