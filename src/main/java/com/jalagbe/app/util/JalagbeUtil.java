package com.jalagbe.app.util;

import com.jalagbe.app.constant.JalagbeConstant;
import com.jalagbe.app.entity.Category;
import com.jalagbe.app.entity.CategoryImage;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rahma on 9/10/2017.
 */
public class JalagbeUtil {

    public static void saveUploadedImages(MultipartFile file, Category category, String storeAbleImageName, String destinationFolder) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(destinationFolder  + storeAbleImageName);
            Files.write(path, bytes);
            CategoryImage categoryImage = new CategoryImage();
            categoryImage.setFileName(storeAbleImageName);
            categoryImage.setCategoryId(category);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUniqueImageName(){
        DateFormat dateFormat =new SimpleDateFormat("dd-MM-yy HH-mm-ss.SSS");
        Date date = new Date();
        String dateName =dateFormat.format(date) ;
        String trimFirst  = dateName.replaceAll("[ :.+-]", "").trim();
        String name = trimFirst +".jpg";
        return  name;
    }

    public static String readImages(String filePath, String imageName) {
        byte[] bFile = readBytesFromFile(filePath+imageName);
        Base64 codec = new Base64();
        byte[] encodedBase64 = codec.encode(bFile);
        return new String(encodedBase64);
    }

    private static byte[] readBytesFromFile(String filePath) {
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return bytesArray;
    }
}
