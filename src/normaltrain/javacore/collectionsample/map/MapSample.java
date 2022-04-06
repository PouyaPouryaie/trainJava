package normaltrain.javacore.collectionsample.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

        Map<String, String> books = new HashMap<>();
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put("978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        Optional<String> optionalIsbn = books.entrySet().stream()
                .filter(e -> "Effective Java".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        optionalIsbn.ifPresent(s -> System.out.println("Isbn is " + s));

        List<String> collect = books.entrySet().stream()
                .filter(e -> e.getKey().startsWith("978-0"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
