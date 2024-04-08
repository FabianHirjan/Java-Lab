package org.example;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create the components
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        add(canvas, BorderLayout.CENTER); // this is BorderLayout.CENTER
        add(configPanel, BorderLayout.NORTH); // this is BorderLayout.NORTH
        add(controlPanel, BorderLayout.SOUTH); // this is BorderLayout.SOUTH

        // invoke the layout manager

        pack();
    }
}
