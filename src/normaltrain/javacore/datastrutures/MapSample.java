package normaltrain.javacore.datastrutures;

import java.util.HashMap;
import java.util.Map;

public class MapSample {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val " + i);
        }

        map.forEach((index, value) -> System.out.println("index " + index + " value " + value));

        map.computeIfPresent(3, (key, value) -> value + key);
        System.out.println("index " + 3 + " after change is " + map.get(3));

        map.computeIfAbsent(10, num -> "val " + num);
        System.out.println(map.get(10));

        map.merge(3, "val 3", (value, newValue) -> newValue);
        System.out.println("index " + 3 + " after merge is " + map.get(3));
    }
}
