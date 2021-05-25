package normaltrain.interfacetrain;

public interface A {

    static final int countUsed = 20;

    static void countPlus(){
        System.out.println("counting");
    }

    default void hello(){
        System.out.println("hello A");
    }
}
