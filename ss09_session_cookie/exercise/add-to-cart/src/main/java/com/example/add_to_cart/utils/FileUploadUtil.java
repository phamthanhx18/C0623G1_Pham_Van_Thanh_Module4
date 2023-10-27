package com.example.add_to_cart.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    private static String uploadDir = "D:\\CodeGym\\C0623G1_Pham_Van_Thanh_Module4\\ss09_session_cookie\\exercise\\add-to-cart\\src\\main\\resources\\static\\image";

    public static void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
        File file = new File(uploadDir, fileName);
        multipartFile.transferTo(file);
    }
}
