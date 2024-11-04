package basictrain.codetrain.javatrain.designPattern;

public class SingletonSample {
    public String str = "Hello I am a singleton! Let me say hello world to you";
    private static SingletonSample instance = null;

    private SingletonSample() {
    }

    public static SingletonSample getSingleInstance(){
        if(instance == null){
            instance = new SingletonSample();
        }
        return instance;
    }

    @Override
    public String toString() {
        return str;
    }
}