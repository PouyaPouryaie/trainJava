package normaltrain.javacore.exception;

import java.io.IOException;

public class ExceptionSample {

    public static void main(String[] args) {

        NullStringClass nullStringClass = new NullStringClass();
        CallerException callerException = new CallerException(nullStringClass);

        // use try-catch block for handle exception of caller method
        try {
            System.out.println(callerException.getSampleFromNullClass().length());
        }catch (IOException ioException){
            System.out.println("io exception is handle");
            ioException.printStackTrace();
        }
    }
}
