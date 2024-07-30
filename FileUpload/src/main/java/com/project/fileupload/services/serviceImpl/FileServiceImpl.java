package com.project.fileupload.services.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.fileupload.services.FileService;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(MultipartFile file, String path) {
        String originalFilename = file.getOriginalFilename();
        String randomFileName = UUID.randomUUID().toString();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileNameWithExtension = randomFileName + extension;
        String pathNameWithExtension = path + fileNameWithExtension;
        if (extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg")
                || extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".pdf")) {
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            try {
                Files.copy(file.getInputStream(), Paths.get(pathNameWithExtension));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fileNameWithExtension;
        } else {
            throw new RuntimeException("Error!! uploaded file not have proper " + extension);
        }
    }

}
