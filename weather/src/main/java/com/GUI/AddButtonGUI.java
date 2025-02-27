package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddButtonGUI extends JFrame {
    public AddButtonGUI() {
        super("Add Place");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] selection = {"Japan", "England", "USA", "Canada"};
        
        JLabel places = new JLabel("Select new place");
        JComboBox list = new JComboBox<>(selection);
        list.setPreferredSize(new Dimension(150, 30));

        JButton confirm = new JButton();

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.getSelectedItem();
            }
        });

        panel.add(places);
        panel.add(list);

        add(panel, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
