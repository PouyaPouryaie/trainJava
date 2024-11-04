package basictrain.codetrain.problemsolving.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You will be given two arrays of integers and asked to determine all integers that
 * satisfy the following two conditions:
 *
 * 1 - The elements of the first array are all factors of the integer being considered
 * 2 - The integer being considered is a factor of all elements of the second array
 *
 * ex : {2 4} {16 32 96} result = 3 {4, 8, 16}
 */

public class BetweenTwoSet {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int maxFromA = Integer.MIN_VALUE;
        int minFromB = Integer.MAX_VALUE;

        maxFromA = a.stream().max(Integer::compareTo).get();
/*        for(Integer max: a){
            if(maxFromA < max){
                maxFromA = max;
            }
        }*/

        minFromB = b.stream().min(Integer::compareTo).get();
/*        for(Integer min: b){
            if(minFromB > min){
                minFromB = min;
            }
        }*/

        List<Integer> mayBeResult = new ArrayList<>();

        int i = 1;
        while(true){
            if(maxFromA * i  <= minFromB){
                mayBeResult.add(maxFromA * i);
            }
            else{
                break;
            }
            i++;
        }

        List<Integer> firstPhase = new ArrayList<>();
        for(Integer numberFromResult : mayBeResult){
            boolean checkinFraction = true;
            for(Integer numberFromA : a){
                if(numberFromResult % numberFromA != 0){
                    checkinFraction = false;
                }
            }
            if(checkinFraction){
                firstPhase.add(numberFromResult);
            }
        }

        List<Integer> secondPhase = new ArrayList<>();
        for(Integer numberFromResult : firstPhase){
            boolean checkinFraction = true;
            for(Integer numberFromB : b){
                if(numberFromB % numberFromResult != 0){
                    checkinFraction = false;
                }
            }
            if(checkinFraction){
                secondPhase.add(numberFromResult);
            }
        }

        return secondPhase.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int total = getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
