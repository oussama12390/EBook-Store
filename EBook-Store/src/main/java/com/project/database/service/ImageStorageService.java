package com.project.database.service;

// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// @Service
// public class ImageStorageService {

//     public String saveImage(MultipartFile file) {
//         return "/book.jpg";
//     }
// }

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
// import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageStorageService {

    @Value("${file.upload-dir}") // Add this to your application.properties with the path to your public folder
    private String uploadDir;

    public String saveImage(MultipartFile file) {
    try {
        // Get the root directory where you want to store the images
        String rootDir = "C:" + File.separator + "Users" + File.separator + "Lenovo" + File.separator + "ReactBookApp" + File.separator + "public";

        // Get the file extension
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

        // Generate a unique filename for the image
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        // Create the complete file path
        String filePath = rootDir + File.separator + uniqueFileName;

        // Save the file
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    } catch (IOException e) {
        throw new RuntimeException("Could not store file. Error: " + e.getMessage(), e);
    }
}

}

