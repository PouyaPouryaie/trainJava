package normaltrain.accesslevel;

import java.util.*;

public class App {

    public static void main(String[] args){

        /**
         * how use hashCode & equal in set for find unique data
         */
        Set<Human> humanSet = new HashSet<>();

        Human h1 = new Human(2020,"pouya", 10_000);
        Human h2 = new Human(2021,"sina", 20_000);
        Human h3 = new Human(2022,"ali", 30_000);
        Human h4 = new Human(2020,"pouya", 10_000);

        List<Human> humanList = new ArrayList<>();

        humanList.add(h1);humanList.add(h2);humanList.add(h3);humanList.add(h4);

        humanSet.addAll(humanList);

        for(Human human: humanSet){
            System.out.println(human.toString());
        }

        humanSet.stream().map(Human::getName).forEach(System.out::println);

    }
}
