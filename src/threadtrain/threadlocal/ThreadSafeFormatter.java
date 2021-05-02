package threadtrain.threadlocal;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {

    // before java-8
/*    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<>(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };*/

    // java-8 use factoryMethod
    public static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void removeThreadLocal(){
        dateFormatter.remove();
    }
}
