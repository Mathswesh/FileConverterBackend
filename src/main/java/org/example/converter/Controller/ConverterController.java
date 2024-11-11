package org.example.converter.Controller;

import org.example.converter.Payload.FileResponse;
import org.example.converter.Service.ServiceImpl.FileConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("converter")
public class ConverterController {
    @Autowired
    private FileConverterImpl converter;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        try {
            fileName = this.converter.uploadImage(path, image);
        } catch (Exception e) {
            return new ResponseEntity<>(new FileResponse(null, "file is not uploaded"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new FileResponse(fileName, "file is successfully uploaded"), HttpStatus.OK);
    }


    @GetMapping("/pngtojpg")
    public ResponseEntity<FileResponse> filetojpg(){
        converter.filetojpg();
        return new ResponseEntity(new FileResponse( "file is successfully Converted from png to jpg format.",null), HttpStatus.OK);
    }

    @GetMapping("/jpgtopng")
    public ResponseEntity<FileResponse> filetopng(){
        converter.filetopng();
        return new ResponseEntity<>(new FileResponse("File is successfully Converted from jpg to png format.",null), HttpStatus.OK);
    }

    @GetMapping("/jpgtopdf")
    public ResponseEntity<FileResponse> filetopdf(){
        converter.filetopdf();
        return new ResponseEntity<>(new FileResponse("File is successfully Converted from jpg to pdf format.",null), HttpStatus.OK);
    }

    @GetMapping("/filetoheic")
    public ResponseEntity<FileResponse> filetoHeic(){
        converter.filetoheic();
        return new ResponseEntity<>(new FileResponse("File is converted successfully to Heic.",null), HttpStatus.OK);
    }
}