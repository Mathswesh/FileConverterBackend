package org.example.converter.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileConverter {
    String uploadImage(String path , MultipartFile file);
    String filetojpg();
    String filetopng();
    String filetopdf();
    String filetoheic();
}
