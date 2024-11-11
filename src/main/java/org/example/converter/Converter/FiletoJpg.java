package org.example.converter.Converter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiletoJpg {
    public void filetojpg(){
        String inputPath = "images/stage.png";
        String outputPath = "images/stage.jpg";

        try {
            // Read the input PNG file
            BufferedImage bufferedImage = ImageIO.read(new File(inputPath));
            // Create a blank, RGB, white image (for jpg format)
            BufferedImage newBufferedImage = new BufferedImage(
                    bufferedImage.getWidth(), bufferedImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            // Draw the original image on the white background
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, java.awt.Color.WHITE, null);
            // Write the image in JPG format
            ImageIO.write(newBufferedImage, "jpg", new File(outputPath));
            System.out.println("Conversion completed: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
