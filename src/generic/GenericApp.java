package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericApp {

    public static void main(String[] args){

        NumberBox<Integer> ni = new NumberBox<>();
        ObjectBox<C> obc = new ObjectBox<>();
        C c = new C(20, 10);
        obc.box(c);
        System.out.println(obc.value());
        ObjectBox<B> obb = new ObjectBox<>();
        B b = new B(30);
        b.setB(40);
        obb.box(b);
        System.out.println(obb.value());
        System.out.println(obb.unBox());

        List<Cats> cats = new ArrayList<>();
        cats.add(new Cats(4,"longHair","brown","brown-white"));
        cats.add(new Cats(4,"longHair","white","white"));
        List<? extends Pets> pets = cats;
        List<? super Cats> catStore= new ArrayList<>();
        catStore.add(new Cats(4,"shaved","pot","pink"));
        Pets pet = new Pets(4,"loose","stupid");

        

        System.out.println(pets.get(0).toString());
    }
}
