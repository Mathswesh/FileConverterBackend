package org.example.converter.Service.ServiceImpl;

import org.example.converter.Converter.FiletoHeic;
import org.example.converter.Converter.FiletoPdf;
import org.example.converter.Converter.FiletoPng;
import org.example.converter.Converter.FiletoJpg;
import org.example.converter.Service.FileConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileConverterImpl implements FileConverter {

    @Override
    public String uploadImage(String path , MultipartFile file) {
        String name = null;
        try {
            //name of file
            name = file.getOriginalFilename();
            //fullpath
            String filePath = path + File.separator + name;
            //create folder if not created
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            //copy file
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String filetojpg(){
        FiletoJpg filetoJpg = new FiletoJpg();
        filetoJpg.filetojpg();
        return "file is converted from png to jpg";
    }

    @Override
    public String filetopng(){
        FiletoPng filetoPng = new FiletoPng();
        filetoPng.filetoPng();
        return "file is converted from jpg to png";
    }

    @Override
    public String filetopdf(){
        FiletoPdf filetoPdf = new FiletoPdf();
        filetoPdf.filetopdf();
        return "file is converted from jpg to pdf";
    }

    @Override
    public String filetoheic(){
        FiletoHeic filetoHeic = new FiletoHeic();
        filetoHeic.filetoHeic();
        return "file is converted to heic";
    }
}
