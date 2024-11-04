package basictrain.javacore.optionalsample;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalSample {
    public static void main(String[] args) {

        Map sample = new HashMap<String, Object>()
        {{
            put("one", 1);
            put("two", 2);
            put("three", 3);
        }};

        Object o = Optional.ofNullable(sample.get("four")).orElseGet(() -> {
            sample.put("four", 4);
            return sample.get("four");
        });
        System.out.println(o);
    }
}
