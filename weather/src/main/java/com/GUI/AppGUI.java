package com.GUI;

import javax.swing.*;

import com.example.WeatherAPI;

import java.awt.*;

public class AppGUI extends JFrame{
    private DefaultListModel<String> listModel;
    private JList<String> placeList;

    public AppGUI() {
        //Window setup
        super("WeatherApp");
        setSize(500, 400);
        setLayout(new BorderLayout());

        //List of places
        listModel = new DefaultListModel<>();
        placeList = new JList<>(listModel);

        JScrollPane listScrollPane = new JScrollPane(placeList);
        listScrollPane.setPreferredSize(new Dimension(120, 100));

        //Button
        JButton addButton = new JButton();
        addButton.setText("Add Place");

        addButton.addActionListener(e -> new AddButtonGUI(this)); 

        // Left panel for list and button
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(120, 120));

        leftPanel.add(listScrollPane, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH); 

        // Main panel with all information
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JLabel timeLabel = new JLabel("Time", SwingConstants.CENTER);
        JLabel weatherLabel = new JLabel("Weather", SwingConstants.CENTER);

        JButton refreshButton = new JButton("Update Weather");
        refreshButton.addActionListener(e -> {
            //String city = "London"; // Zatím pevně dané, později vybereš z listu
            String place = placeList.getSelectedValue();
            String weatherData = WeatherAPI.getWeather(place);
            String timeData = WeatherAPI.getTime(place);
            weatherLabel.setText(weatherData);
            timeLabel.setText(timeData);
        });

        mainPanel.add(timeLabel);
        mainPanel.add(weatherLabel);
        mainPanel.add(refreshButton);

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