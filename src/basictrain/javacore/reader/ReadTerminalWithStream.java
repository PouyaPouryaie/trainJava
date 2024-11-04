package basictrain.javacore.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ReadTerminalWithStream {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String data = "";
        do {
            data = br.readLine();
            System.out.println(data);
        } while (!Objects.equals(data, "true"));
        br.close();
        isr.close();
    }
}
