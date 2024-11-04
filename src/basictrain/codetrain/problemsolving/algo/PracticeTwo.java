package basictrain.codetrain.problemsolving.algo;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * compareTriplets
 */
public class PracticeTwo {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        Integer[] compare = new Integer[]{0,0};

        for(int i=0; i < a.size(); i++){
            if(a.get(i) > b.get(i)){
                compare[0] += 1;
            }
            else if(a.get(i) < b.get(i)){
                compare[1] += 1;
            }
        }

        return Arrays.asList(compare);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
