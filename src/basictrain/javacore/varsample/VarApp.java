package basictrain.javacore.varsample;

public class VarApp {

    public static void main(String[] args){

        var o = new Object(){
            public void bar(){
                System.out.println("hello bar");
            }
        };

        o.bar();
    }
}
