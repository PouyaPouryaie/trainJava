package basictrain.javacore.comparator;

import java.util.Comparator;

public class AgeCompare implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
