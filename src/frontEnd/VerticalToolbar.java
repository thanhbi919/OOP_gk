package frontEnd;

import java.awt.*;

import javax.swing.*;

public class VerticalToolbar extends JToolBar {

    static JTextField sNodeText = new JTextField(10);
    static JTextField dNodeText = new JTextField(10);

    public VerticalToolbar(MenuListener menulistener) {
        initVerticalToolbar(menulistener);
    }

    private void initVerticalToolbar(MenuListener menulistener) {
        setFloatable(false);
        setMargin(new Insets(50, 10, 5, 5));
        setLayout(new GridBagLayout());

        // Declare components
        JLabel sNodeLabel = new JLabel("Start Node: ");
        JLabel dNodeLabel = new JLabel("Destination Node:  ");

        JButton execButton = new JButton("Run");
        execButton.setActionCommand("run");
        // Add components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
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
        execButton.addActionListener(menulistener);
        add(execButton, gbc);
    }

    public static String[] getSD() {
        String[] sourceDestination = new String[2];
        sourceDestination[0] = sNodeText.getText();
        sourceDestination[1] = dNodeText.getText();
        return sourceDestination;
    }

}
