package lambdatrain.functionalprogramming.callback;

import java.util.Objects;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        simple("pouya","pouryaie", null);

        simple("simin",null, value -> {
            System.out.println("no lastName provided for " + value);
        });

        simple2("simin",null, () -> {
            System.out.println("no lastName provided");
        });
    }

    static void simple(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (Objects.nonNull(lastName)) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void simple2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (Objects.nonNull(lastName)) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

/* this is source of callback in js
    function simple(firstName, lastName, callback){
        console.log(firstName);

        if(lastName){
            console.log(lastName);
        }else{
            callback();
        }
    }
    simple("pouya", null, function () {console.log("there is not lastName")})
    */
}
