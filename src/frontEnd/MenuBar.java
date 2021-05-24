package frontEnd;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(MenuListener menuItemListener) {
        // Decalre menus
        JMenu fileMenu = new JMenu("File");
        fileMenu.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\file1.png"));

        JMenu viewMenu = new JMenu("View");
        viewMenu.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\edit.png"));

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\help1.png")); // NOI18N
   

        // Decalre menu items
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setActionCommand("open");
        openMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Open file.png")); 
        
        

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setActionCommand("saveText");
        saveMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Save.png")); 



        JMenuItem saveasMenuItem = new JMenuItem("Save as");
        saveasMenuItem.setActionCommand("saveasText");
        saveasMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Save as.png")); 


        JMenuItem exportImg = new JMenuItem("Export");
        exportImg.setActionCommand("exportImg");
        exportImg.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Hnet.com-image (1).png")); // NOI18N


        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setActionCommand("exit");
        exitMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Exit.png")); // NOI18N


        JMenuItem sizeMenuItem = new JMenuItem("Change font size");
        sizeMenuItem.setActionCommand("setFont");
        sizeMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\resize 1.png")); // NOI18N


        JMenuItem colorMenuItem = new JMenuItem("Change color");
        colorMenuItem.setActionCommand("setColor");
        colorMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\change color.png")); // NOI18N


        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.setActionCommand("help");
        helpMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Help.png")); // NOI18N



        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setActionCommand("about");
        aboutMenuItem.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\OOP_PROJECT\\FrontEnd\\OOP_gk\\src\\Hinh\\Hnet.com-image (2).png")); // NOI18N



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
