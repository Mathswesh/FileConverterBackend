package org.example.converter.Converter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.IOException;

public class FiletoPdf {
    public void filetopdf(){

        String inputImagePath = "images/stage.jpg";
        String outputPdfPath = "images/stage.pdf";

        try (PDDocument document = new PDDocument()) {
            // Load the image
            PDImageXObject pdImage = PDImageXObject.createFromFile(inputImagePath, document);

            // Create a new page with dimensions based on the image
            PDRectangle rectangle = new PDRectangle(pdImage.getWidth(), pdImage.getHeight());
            PDPage page = new PDPage(rectangle);
            document.addPage(page);

            // Draw the image on the page
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.drawImage(pdImage, 0, 0, rectangle.getWidth(), rectangle.getHeight());
            }

            // Save the PDF
            document.save(outputPdfPath);
            System.out.println("Conversion completed: " + outputPdfPath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}