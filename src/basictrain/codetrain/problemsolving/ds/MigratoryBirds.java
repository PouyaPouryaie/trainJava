package basictrain.codetrain.problemsolving.ds;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        //first solution
/*        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }
            else{
                map.put(i, 1);
            }
        }

        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        int max = 0;
        int index = 0;
        for(int i:collect){
            if(map.get(i) > max){
                max = map.get(i);
                index = i;
            }
        }
        return index;*/

        //second solution
        int[] arrayList = new int[arr.size()];

        for(int i: arr){
            arrayList[i-1]++;
        }

        int max = 0;
        int index = 0;
        for(int i=0; i < arrayList.length; i++){
            if(arrayList[i] > max){
                max = arrayList[i];
                index = i+1;
            }
        }

        return index;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
