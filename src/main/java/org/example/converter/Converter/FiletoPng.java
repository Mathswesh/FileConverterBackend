package org.example.converter.Converter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiletoPng {
    public void filetoPng() {
        String inputPath = "images/stage.jpg";
        String outputPath = "images/stage.png";

        try {
            // Read the input JPG file
            BufferedImage bufferedImage = ImageIO.read(new File(inputPath));

            // Write the image in PNG format
            ImageIO.write(bufferedImage, "png", new File(outputPath));

            System.out.println("Conversion completed: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
