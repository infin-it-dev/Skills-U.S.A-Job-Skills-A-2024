package BrightSpotDetector;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrightSpotDetectorGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bright Spot Detector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Load the image
            // Change the file path to the location of your image
            BufferedImage image = ImageIO.read(new File("C://Users//rylan//Downloads//Untitled design.png/"));

            // Detect bright spots
            List<Point> brightSpots = detectBrightSpots(image);

            // Create a custom panel to display the image and bright spots
            ImagePanel imagePanel = new ImagePanel(image, brightSpots);

            // Add the panel to the frame
            frame.getContentPane().add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static List<Point> detectBrightSpots(BufferedImage image) {
        // Call the detection logic from the original code or modify it as needed
        BrightSpotDetector.detectBrightSpots(image); // Modify this line to return a List<Point>
        // Add the logic to detect bright spots and return a List<Point>
        List<Point> brightSpots = new ArrayList<>(); // Example: create an empty list
        // Add the logic to detect bright spots and populate the list
        // ...
        return brightSpots;
    }
}

class ImagePanel extends JPanel {
    private BufferedImage image;
    private List<Point> brightSpots;

    public ImagePanel(BufferedImage image, List<Point> brightSpots) {
        this.image = image;
        this.brightSpots = brightSpots;
    }

    class CustomImagePanel extends JPanel {
        private BufferedImage image;
        private List<Point> brightSpots;

        public CustomImagePanel(BufferedImage image, List<Point> brightSpots) {
            this.image = image;
            this.brightSpots = brightSpots;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the image
            g.drawImage(image, 0, 0, this);

            // Draw bright spots as red dots
            g.setColor(Color.RED);
            for (Point brightSpot : brightSpots) {
                int x = (int) brightSpot.getX();
                int y = (int) brightSpot.getY();
                g.fillOval(x - 2, y - 2, 5, 5);
            }
        }
    }

}
