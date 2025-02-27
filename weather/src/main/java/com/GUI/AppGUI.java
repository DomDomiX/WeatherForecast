package com.GUI;

import javax.swing.*;
import com.GUI.AddButtonGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame{
    private DefaultListModel<String> listModel;
    private JList<String> placeList;

    public AppGUI() {
        //Window setup
        super("WeatherApp");
        setSize(800, 800);
        setLayout(new BorderLayout());

        //List of places
        listModel = new DefaultListModel<>();
        placeList = new JList<>(listModel);

        JScrollPane listScrollPane = new JScrollPane(placeList);
        listScrollPane.setPreferredSize(new Dimension(200, 800));

        //Button
        JButton addButton = new JButton();
        addButton.setText("Add Place");

        addButton.addActionListener(e -> new AddButtonGUI(this)); 

        // Left panel for list and button
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(200, 800));

        leftPanel.add(listScrollPane, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH); 

        // Main panel with all information
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JLabel timeLabel = new JLabel("Time", SwingConstants.CENTER);
        JLabel weatherLabel = new JLabel("Weather", SwingConstants.CENTER);

        mainPanel.add(timeLabel);
        mainPanel.add(weatherLabel);

        // Add components to the window
        add(leftPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addPlace(String place) {
        listModel.addElement(place);
    }
}