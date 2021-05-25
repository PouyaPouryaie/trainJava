package threadtrain.multiThread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;

/**
 * use callable for read txt file and print it
 */
public class ReadText {

    final static String FILE_PATH = "D:\\work\\subWork\\code-train\\codeTrain\\mytxt.txt";

    public static void main(String[] args) {
        Callable<String> c = () -> {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line = "";
            String result = "";
            while ((line = br.readLine()) != null){
                result += line + "\n";
            }
            return result;
        };

        try{
            String s = c.call();
            System.out.println(s);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
