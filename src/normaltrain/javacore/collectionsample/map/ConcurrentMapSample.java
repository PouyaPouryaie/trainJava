package normaltrain.javacore.collectionsample.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * How use ConcurrentMap and modify data in map.
 */
public class ConcurrentMapSample {

    public static void main(String[] args) {

        Map<Long, List<Map<String, Object>>> concurrentSampleMap = new ConcurrentHashMap<>();

        List<Map<String, Object>> sampleList = new ArrayList<>() {{
            add(new ConcurrentHashMap<>() {{
                put("name", "n1");
            }});
            add(new ConcurrentHashMap<>() {{
                put("name", "n2");
            }});
            add(new ConcurrentHashMap<>() {{
                put("name", "n3");
            }});
            add(new ConcurrentHashMap<>() {{
                put("name", "n4");
            }});
        }};

        List<Map<String, Object>> sampleList2 = new ArrayList<>();
        sampleList2.add(new ConcurrentHashMap<>(Map.of("name", "n1")));
        sampleList2.add(new ConcurrentHashMap<>(Map.of("name", "n2")));
        sampleList2.add(new ConcurrentHashMap<>(Map.of("name", "n3")));
        sampleList2.add(new ConcurrentHashMap<>(Map.of("name", "n4")));

        concurrentSampleMap.put(1L, sampleList);
        concurrentSampleMap.put(2L, sampleList2);

        concurrentSampleMap.get(2L).forEach(map -> {
            if (map.get("name").equals("n3")) {
                map.put("name", "found");
            }
        });

        concurrentSampleMap.get(2L).stream().forEach(System.out::println);
    }
}
