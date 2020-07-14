package com.haochang.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @description: 描述：pdf
 * @author: youzhi.gao
 * @date: 2020-06-04 11:23
 */
public class PDFtest {
    public static void main(String[] args) {

   // TODO Auto-generated method stub
    try {
        String encodedBytes =  readFile("E:\\test.txt", StandardCharsets.UTF_8);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes;
        decodedBytes = decoder.decodeBuffer(encodedBytes);

        File file = new File("E:\\newfile.pdf");;
        FileOutputStream fop = new FileOutputStream(file);

        fop.write(decodedBytes);
        fop.flush();
        fop.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}


 class Base64ConverterUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Base64ConverterUtils.class);

    public static void Base64Converter(String encodedBytes, String tempPath) {
        // BASE64Decoder decoder = new BASE64Decoder();

        LOGGER.info("The file temp saved in :"+tempPath);
        byte[] decodedBytes;
        try {
            decodedBytes = Base64.getDecoder().decode(encodedBytes); // decoder.decodeBuffer(encodedBytes);
            File file = new File(tempPath);
            FileOutputStream fop = new FileOutputStream(file);
            fop.write(decodedBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            LOGGER.error("write file to server occurred exception,the reason: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
