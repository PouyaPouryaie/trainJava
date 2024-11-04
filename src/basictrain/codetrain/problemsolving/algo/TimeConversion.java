package basictrain.codetrain.problemsolving.algo;

import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hoursIndex = 0;
        StringBuilder timeConvert = new StringBuilder();

        String[] timeDecompose = s.split(":");
        hoursIndex += Integer.parseInt(timeDecompose[0]);
        if(s.contains("PM") && hoursIndex < 12){
            hoursIndex += 12;
        }
        if(s.contains("AM") && hoursIndex == 12){
            hoursIndex = 0;
        }
        String hours = String.valueOf(hoursIndex);
        if(hoursIndex < 10){
            hours = "0" + hours;
        }
        timeDecompose[0] = hours;
        for(int i = 0; i < timeDecompose.length; i++){
            timeConvert.append(timeDecompose[i] + ":");
        }
        String result = timeConvert.toString();
        result = result.replaceAll("[AMP]","");
        result = result.substring(0, result.length()-1);
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scan.nextLine();

        String s = "12:00:00AM";
        String s1 = "12:00:00PM";
        String s2 = "12:59:50AM";
        String s3 = "00:00:00AM";
        String s4 = "07:00:23AM";
        String s5 = "02:00:23PM";
        String s6 = "12:45:54PM";

        String result = timeConversion(s);

        timeConversion(s1);
        timeConversion(s2);
        timeConversion(s3);
        timeConversion(s4);
        timeConversion(s5);
        timeConversion(s6);

        //bw.write(result);
        //bw.newLine();

        //bw.close();

        scan.close();
    }
}
