package basictrain.codetrain.problemsolving.algo;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lily has a chocolate bar that she wants to share it with Ron for his birthday.
 * Each of the squares has an integer on it.
 * She decides to share a contiguous segment of the bar selected such that the length of
 * the segment matches Ron's birth month and the sum of the integers on the squares is equal to his birth day.
 * You must determine how many ways she can divide the chocolate.
 *
 */
public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;

        for(int i = 0; i < (s.size() - m + 1) ; i++){
            int result = 0;
            for(int j = 0; j < m; j++){
                result = result + s.get(i+j);
            }
            if(result == d){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
