package reactivetrain.pushbased;

public interface CallBack {

    void pushData(String s);
    void pushComplete();
    void pushError(Exception e);
}
