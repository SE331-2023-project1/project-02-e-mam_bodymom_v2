package se331.project.rest.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import se331.project.rest.util.CloudStorageHelper;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor

public class BucketController {

    final CloudStorageHelper cloudStorageHelper;

    @PostMapping("/uploadFile")
    @CrossOrigin(origins = "http://localhost:3000 , http://18.208.106.67:8001")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")MultipartFile file)
            throws ServletException, IOException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"imageupload-f10a5.appspot.com"));
    }

    @PostMapping("/uploadImage")
    @CrossOrigin(origins = "http://localhost:3000 , http://18.208.106.67:8001")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image")MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDto(file, "imageupload-f10a5.appspot.com"));
    }
}
