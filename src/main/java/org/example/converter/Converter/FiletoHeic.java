package org.example.converter.Converter;

import java.io.IOException;

public class FiletoHeic {
    public void filetoHeic(){
        String inputImagePath = "images/stage.png";
        String outputImagePath = "image/stage.heic";

        boolean success = convertPngToHeic(inputImagePath, outputImagePath);
        if (success) {
            System.out.println("Conversion successful!");
        } else {
            System.out.println("Conversion failed.");
        }
    }

    public boolean convertPngToHeic(String inputImagePath, String outputImagePath) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "ffmpeg",
                "-i", inputImagePath,
                "-c:v", "hevc",
                "-f", "heic",
                outputImagePath
        );

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
