package streamtrain.exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamHandleException {

    public static void main(String[] args) {

        List<String> list = List.of("1", "2", "x");

        list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), RuntimeException.class));

        List<Integer> list1 = Arrays.asList(1000,2000);

        list1.forEach(handleCheckedExceptionConsumer(Thread::sleep));
    }

    //first Solution
    static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> payload,
                                                                                     Class<ExObj> exObjClass) {
        return obj -> {
            try {
                payload.accept(obj);
            } catch (Exception ex) {
                try {
                    ExObj exObj = exObjClass.cast(ex);
                    System.out.println("exception " + exObj.getMessage());
                } catch (ClassCastException ecx) {
                    throw ecx;
                }
            }
        };
    }

    //second Solution
    static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target, Exception> handlerConsumer) {
        return obj -> {
            try {
                handlerConsumer.accept(obj);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
