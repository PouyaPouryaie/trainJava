package normaltrain.codetrain.problemsolving.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Diagonal Difference
 */
class PracticeFour {


    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int matrixSize = arr.size();
        int firstDiagonal = 0;
        int secondDiagonal = 0;

        arr.stream().forEach(i -> {
            int index = 0;
            i.get(index);
            index++;
        });

        for(int i =0; i < matrixSize; i++){
            firstDiagonal = firstDiagonal + arr.get(i).get(i);
            secondDiagonal = secondDiagonal + arr.get(i).get(matrixSize - (i+1));
        }

        return Math.abs(firstDiagonal - secondDiagonal);
    }

}

class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = PracticeFour.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
