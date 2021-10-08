package normaltrain.stringsample;

import java.lang.reflect.Field;

public class StringSample {

    public static void main(String[] args) {

        //how read string and add character in string with replace method
        Class c = Sample.class;
        try {
            Field lastName = c.getDeclaredField("lastName");
            String s = lastName.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
            System.out.println(s);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println(c.getName());
    }
}
