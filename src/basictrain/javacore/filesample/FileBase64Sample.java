package basictrain.javacore.filesample;

import java.io.*;
import java.util.Base64;

public class FileBase64Sample {

    public static void main(String[] args) {

        //Read Source
        File source = new File("white_sand-wallpaper-1920x1080.jpg");

        //Write Source
        String path = "image.jpg";
        byte[] bytes;
        try {
            FileInputStream in = new FileInputStream(source);
            bytes = in.readAllBytes();
            Base64.Encoder encoder =  Base64.getEncoder();
            byte[] encode = encoder.encode(bytes);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] imageBytes = decoder.decode(encode);
            File result =new File(path);
            OutputStream outputStream = new FileOutputStream(result);
            outputStream.write(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("is done");
    }
}
