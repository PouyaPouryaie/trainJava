package streamtrain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NestedLoopWithStream {

    public static void main(String[] args){

        int[] a = new int[]{1,2,3,4,5,6};
        List<Integer> l1 = new ArrayList<>();

        for(int i : a){
            l1.add(i);
        }

        int[] b = new int[]{3,4,6,7,9,10};
        List<Integer> l2 = new ArrayList<>();

        for(int i : b){
            l2.add(i);
        }

        List<Integer> l3 = new ArrayList<>();

        for(int i=0; i < l1.size(); i++){
            for(int j =0 ; j < l2.size(); j++){
                if(l1.get(i) == l2.get(j)){
                    l3.add(l1.get(i));
                }
            }
        }


        System.out.println(l3.toString());


        //stream for nested loop
        List<Integer> l4 = l1.stream()
                .filter(numa -> l2.stream()
                        .anyMatch(numb -> numb.equals(numa)))
                .collect(Collectors.toList());

        System.out.println(l4);
    }
}
