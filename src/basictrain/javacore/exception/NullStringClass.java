package basictrain.javacore.exception;

public class NullStringClass {

    String sample = null;

    public NullStringClass() {
    }

    //this method throw unchecked exception without handle by self
    public String getSample() {
        throw new NullPointerException("this class string message is null");
    }
}
