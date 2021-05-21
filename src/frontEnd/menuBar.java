package frontEnd;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import backEnd.openFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class menuBar extends JMenuBar {

    public menuBar(MenuListener menuItemListener) {
        // Decalre menus
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        // Decalre menu items
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setActionCommand("open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setActionCommand("saveText");
        JMenuItem saveasMenuItem = new JMenuItem("Save as");
        saveasMenuItem.setActionCommand("saveasText");
        JMenuItem exportImg = new JMenuItem("Export");
        exportImg.setActionCommand("exportImg");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setActionCommand("exit");
        JMenuItem sizeMenuItem = new JMenuItem("Change font size");
        sizeMenuItem.setActionCommand("setFont");
        JMenuItem colorMenuItem = new JMenuItem("Change color");
        colorMenuItem.setActionCommand("setColor");
        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.setActionCommand("help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setActionCommand("about");

        // Add listenmer
        // MenuListener menuItemListener = new MenuListener(app);
        openMenuItem.addActionListener(menuItemListener);
        saveMenuItem.addActionListener(menuItemListener);
        saveasMenuItem.addActionListener(menuItemListener);
        exportImg.addActionListener(menuItemListener);
        exitMenuItem.addActionListener(menuItemListener);

        sizeMenuItem.addActionListener(menuItemListener);
        colorMenuItem.addActionListener(menuItemListener);

        helpMenuItem.addActionListener(menuItemListener);
        aboutMenuItem.addActionListener(menuItemListener);

        // Add menu items to menus
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveasMenuItem);
        fileMenu.add(exportImg);
        fileMenu.add(exitMenuItem);

        viewMenu.add(sizeMenuItem);
        viewMenu.add(colorMenuItem);

        helpMenu.add(helpMenuItem);
        helpMenu.add(aboutMenuItem);

        // Add menus to menubar
        add(fileMenu);
        add(viewMenu);
        add(helpMenu);
    }
}
