package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private boolean[][] stones;
    private boolean[][] blueStones;

    private List<Point> allowedNodes;

    BufferedImage image;
    Graphics2D offscreen;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    public BufferedImage getImage() {
        return image; // Assuming 'image' is your BufferedImage object
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
            }
        });
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        this.stones = new boolean[rows][cols];
        this.blueStones = new boolean[rows][cols];

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        generateRandomLines();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
        paintGrid((Graphics2D) graphics);
        paintStones((Graphics2D) graphics);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }

        // intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void generateRandomLines() {
        Random random = new Random();
        allowedNodes = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = x1 + cellWidth;
                int y2 = y1;
                if (random.nextDouble() < 0.5) {
                    offscreen.setStroke(new BasicStroke(3));
                    offscreen.setColor(Color.BLACK);
                    offscreen.drawLine(x1, y1, x2, y2);
                    allowedNodes.add(new Point(x1, y1));
                    allowedNodes.add(new Point(x2, y2));
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = x1;
                int y2 = y1 + cellHeight;
                if (random.nextDouble() < 0.5) {
                    offscreen.setStroke(new BasicStroke(3));
                    offscreen.setColor(Color.BLACK);
                    offscreen.drawLine(x1, y1, x2, y2);
                    allowedNodes.add(new Point(x1, y1));
                    allowedNodes.add(new Point(x2, y2));
                }
            }
        }

        offscreen.setStroke(new BasicStroke(1));
    }


    private void paintStones(Graphics2D g) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                if (stones[row][col]) {
                    g.setColor(Color.RED);
                    g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                } else if (blueStones[row][col]) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                }
            }
        }
    }

    private void drawStone(int x, int y) {
        int closestRow = -1;
        int closestCol = -1;
        double minDistance = Double.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int nodeX = padX + col * cellWidth;
                int nodeY = padY + row * cellHeight;
                double distance = Math.sqrt(Math.pow(x - nodeX, 2) + Math.pow(y - nodeY, 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestRow = row;
                    closestCol = col;
                }
            }
        }

        Point closestNode = new Point(padX + closestCol * cellWidth, padY + closestRow * cellHeight);
        if (allowedNodes.contains(closestNode) && !stones[closestRow][closestCol]) {
            repaint();
            stones[closestRow][closestCol] = true;
            placeBlueStone();
        }
    }

    private void placeBlueStone() {
        Random random = new Random();
        int blueRow, blueCol;
        do {
            blueRow = random.nextInt(rows);
            blueCol = random.nextInt(cols);
        } while (stones[blueRow][blueCol]);
        blueStones[blueRow][blueCol] = true;
    }

    public void clearStones() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stones[i][j] = false;
                blueStones[i][j] = false;
            }
        }

        repaint();
    }

    public void clearCanvas() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                stones[i][j] = false;
                blueStones[i][j] = false;
            }
        }
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        repaint();
    }

    public GameState getCurrentGameState() {
        List<Point> redStonePositions = new ArrayList<>();
        List<Point> blueStonePositions = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (stones[row][col]) {
                    // Convert row and col to actual x and y positions
                    int x = padX + col * cellWidth;
                    int y = padY + row * cellHeight;
                    redStonePositions.add(new Point(x, y));
                }
                if (blueStones[row][col]) {
                    int x = padX + col * cellWidth;
                    int y = padY + row * cellHeight;
                    blueStonePositions.add(new Point(x, y));
                }
            }
        }

        return new GameState(redStonePositions, blueStonePositions);
    }
    public void loadGameState(GameState gameState) {
        // Aici trebuie să restaurați starea jocului în funcție de informațiile din obiectul GameState
        // De exemplu, puteți actualiza listele de pietre roșii și albastre cu cele din GameState
        List<Point> redStones = gameState.getRedStones();
        List<Point> blueStones = gameState.getBlueStones();

        // După ce ați actualizat starea jocului, redesenați panoul pentru a reflecta schimbările
        repaint();
    }


}

