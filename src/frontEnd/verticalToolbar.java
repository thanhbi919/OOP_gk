package frontEnd;

import java.awt.*;

import javax.swing.*;

public class verticalToolbar extends JToolBar {
    public verticalToolbar() {
        initVerticalToolbar();
    }

    private void initVerticalToolbar() {
        setFloatable(false);
        setMargin(new Insets(50, 10, 5, 5));
        setLayout(new GridBagLayout());
        JPanel trace = new JPanel();

        // Declare components
        JLabel sNodeLabel = new JLabel("Start Node: ");
        JLabel dNodeLabel = new JLabel("Destination Node:  ");

        JTextField sNodeText = new JTextField(10);
        JTextField dNodeText = new JTextField(10);

        JButton execButton = new JButton("Run");

        // Add components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0.4;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sNodeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(sNodeText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(dNodeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(dNodeText, gbc);

        gbc.weighty = 10;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(execButton, gbc);
    }
}
