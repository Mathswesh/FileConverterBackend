package org.example.converter.Payload;

import lombok.Data;

public class FileResponse {
    private String fileName;
    private String message;

    public FileResponse(String message, String fileName) {
        this.message = message;
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
