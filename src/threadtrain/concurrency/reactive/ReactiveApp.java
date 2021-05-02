package threadtrain.concurrency.reactive;

public class ReactiveApp {


    public static void main(String[] args){



        ArithmeticCell c3 = new ArithmeticCell("c3");
        SimpleCell c2 = new SimpleCell("c2");
        SimpleCell c1 = new SimpleCell("c1");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        System.out.println(c3.getLeft());

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);
    }
}
