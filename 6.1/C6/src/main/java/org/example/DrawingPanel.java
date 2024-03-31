package org.example;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int columns = 10;
        int rows = 10;

        int cellWidth = width / columns;
        int cellHeight = height / rows;

        for (int i = 0; i <= columns; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int i = 0; i <= rows; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
    }
}
