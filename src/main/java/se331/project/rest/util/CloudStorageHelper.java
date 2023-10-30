package se331.project.rest.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.servlet.ServletException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class CloudStorageHelper {
    private static Storage storage = null;

    static {
        InputStream serviceAccount = null;
        try {
            serviceAccount = new ClassPathResource("imageupload-f10a5-e7c96cbf57f4.json").getInputStream();
            storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("imageupload-f10a5")
                    .build().getService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // [END init]

    public String generatePreviewUrl(String bucketName, String fileName) {
        // Construct the URL for previewing the file
        return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
    }

    public String uploadFile(MultipartFile filePart, final String bucketName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
        String dtString = sdf.format(new Date());
        final String fileName = dtString + "-" + filePart.getOriginalFilename();
        InputStream is = filePart.getInputStream();

        BlobInfo blobInfo = storage.create(BlobInfo.newBuilder(bucketName, fileName)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .setContentType(filePart.getContentType()).build(), is);

        // Now, you can generate the preview URL for the file
        String previewUrl = generatePreviewUrl(bucketName, fileName);

        return previewUrl;
    }


//    public String getImageUrl(MultipartFile file, final String bucket) throws IOException, ServletException {
//        final String fileName = file.getOriginalFilename();
//        if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
//            final String extension = fileName.substring(fileName.lastIndexOf('.')+ 1);
//            String[] allowedExt = { "jpg", "jpeg", "png", "gif" };
//            for (String s : allowedExt) {
//                if (extension.equals(s)) {
//                    return this.uploadFile(file, bucket);
//                }
//            }
//            throw new ServletException("file must be an image");
//        }
//        return null;
//    }


//    public StorageFileDTO getStorageFileDto(MultipartFile file, final String bucket)
//            throws IOException, ServletException {
//        final String fileName = file.getOriginalFilename();
//        // Check file extension
//
//        if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
//            final String extension = fileName.substring(fileName.lastIndexOf('.')+ 1);
//            String[] allowedExt = { "jpg", "jpeg", "png", "gif" };
//            for (String s : allowedExt) {
//                if (extension.equals(s)) {
//                    String urlName = this.uploadFile(file, bucket);
//                    return StorageFileDTO.builder().name(urlName).build();
//                }
//            }
//            throw new ServletException("file must be an image");
//        }
//        return null;
//    }

    public String getImageUrl(MultipartFile file, final String bucket) throws IOException, ServletException {
        final String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.isEmpty()) {
            return this.uploadFile(file, bucket);
        }
        return null;
    }

    public StorageFileDTO getStorageFileDto(MultipartFile file, final String bucket) throws IOException, ServletException {
        String urlName = this.uploadFile(file, bucket);
        return StorageFileDTO.builder().name(urlName).build();
    }


}

