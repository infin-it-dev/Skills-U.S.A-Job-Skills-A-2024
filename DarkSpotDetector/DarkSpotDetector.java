import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DarkSpotDetector {

    public static void main(String[] args) {
        try {
            // Load the image
            BufferedImage image = ImageIO.read(new File("C://Users/rylan/Downloads//4958480.jpg"));

            // Detect dark spots
            detectDarkSpots(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void detectDarkSpots(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Threshold value to determine darkness
        int threshold = 50;

        // Loop through each pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get RGB values of the pixel
                int rgb = image.getRGB(x, y);

                // Extract red, green, and blue components
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Calculate darkness (average of RGB components)
                int darkness = (red + green + blue) / 3;

                // Check if the pixel is dark
                if (darkness < threshold) {
                    System.out.println("Dark spot detected at coordinates: (" + x + ", " + y + ")");
                    // You can perform further actions for dark spots if needed
                }
            }
        }
    }
}
