package normaltrain.hirarchytrain;

public class App {


    public static void main(String[] args){
        DClass dClass = new DClass();

        System.out.println(dClass.result(2));
        System.out.println(((CClass)dClass.getObject()).aAbstract(20));
    }
}
