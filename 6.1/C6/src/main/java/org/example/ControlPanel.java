package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    private JButton exitButton = new JButton("Exit");
    private JButton saveButton = new JButton("Save"); // Assuming this is for game state
    private JButton loadButton = new JButton("Load"); // Assuming this is for game state
    private JButton resetButton = new JButton("Reset");
    private JButton saveImg = new JButton("Save IMG");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 5)); // Adjusted for the new button

        // Adding buttons to the panel
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
        add(saveImg);

        // Setting up button actions
        exitButton.addActionListener(this::exitGame);
        saveButton.addActionListener(this::saveGame); // Placeholder for actual implementation
        loadButton.addActionListener(this::loadGame); // Placeholder for actual implementation
        resetButton.addActionListener(this::resetGame);
        saveImg.addActionListener(this::saveImage); // Corrected to call saveImage method
    }

    // Placeholder methods for game actions


    private void saveGame(ActionEvent actionEvent) {
        // Presupunem că există o metodă în DrawingPanel care returnează un obiect GameState actual.
        GameState gameState = frame.canvas.getCurrentGameState();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(gameState);
                JOptionPane.showMessageDialog(this, "Game state saved successfully to " + fileToSave.getAbsolutePath(), "Game Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException i) {
                i.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to save game state: " + i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadGame(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a game state file to load");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Serialized GameState Files", "ser");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            try (FileInputStream fileIn = new FileInputStream(fileToLoad);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                GameState gameState = (GameState) in.readObject();
                frame.canvas.loadGameState(gameState);
                JOptionPane.showMessageDialog(this, "Game state loaded successfully from " + fileToLoad.getAbsolutePath(), "Game Loaded", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to load game state: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    private void resetGame(ActionEvent actionEvent) {
        frame.canvas.clearStones();
    }

    private void exitGame(ActionEvent actionEvent) {
        frame.dispose();
    }



    private void saveImage(ActionEvent actionEvent) {
        try {
            BufferedImage image = frame.canvas.getImage(); // Assuming there's a getImage method returning the BufferedImage
            File outputFile = new File("drawing.png");
            ImageIO.write(image, "PNG", outputFile);
            JOptionPane.showMessageDialog(this, "Image saved to " + outputFile.getAbsolutePath(), "Image Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
