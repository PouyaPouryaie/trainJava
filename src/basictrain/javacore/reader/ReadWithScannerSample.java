package basictrain.javacore.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class ReadWithScannerSample {

    public static void main(String[] args) throws FileNotFoundException {

        /* read from keyboard */
        Scanner scan = new Scanner(System.in);
        var data = "";
        do {
            data = scan.nextLine();
            System.out.println(data);
        } while (!Objects.equals(data, "true"));

        /* read from file */
        System.out.println("!!! start read File");
        URL  url = ReadWithScannerSample.class.getResource("edit.txt");
        try {
            File file = new File(url.getPath());
            scan = new Scanner(file);
        }catch (NullPointerException e){
            System.out.println("url not exist");
        }
        while (scan.hasNextLine()){
            data = scan.nextLine();
            System.out.println(data);
        }
        System.out.println("!!! finish read File");
        scan.close();
    }
}
