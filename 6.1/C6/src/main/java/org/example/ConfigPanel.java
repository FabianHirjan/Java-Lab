package org.example;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerX, spinnerY;
    JButton createButton = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // create the label and the spinner
        label = new JLabel("Grid size: ");
        spinnerX = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerY = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label); // JPanel uses FlowLayout by default
        add(spinnerX);
        add(spinnerY);
        add(createButton);

        createButton.addActionListener(this::createGrid);
    }

    public int getRows() {
        return (int) spinnerX.getValue();
    }

    public int getCols() {
        return (int) spinnerY.getValue();
    }

    private void createGrid(java.awt.event.ActionEvent e) {
        frame.canvas.clearCanvas();
        frame.canvas.init(getRows(), getCols());
        frame.canvas.repaint();
    }


}