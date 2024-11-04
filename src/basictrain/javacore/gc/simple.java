package basictrain.javacore.gc;

import java.lang.ref.SoftReference;

public class simple {

    public static void main(String[] args) {

        RefService refService = new RefService();

        System.out.println(refService.getName());

        RefObj result = refService.getRef();

        System.out.println(result.toString());

        //part 2
        RefObj refObj = new RefObj(10, "alireza");
        SoftReference<RefObj> softReference = new SoftReference<>(refObj);
        refObj = null;
        System.out.println(softReference.get());
        refObj = new RefObj(20, "sina");
        softReference.clear();
        System.out.println(softReference.get());
        System.out.println(refObj);
    }
}
