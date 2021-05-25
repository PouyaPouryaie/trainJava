package normaltrain.iterationsubset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    static List<List<Integer>> subsets(List<Integer> list){
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer fst = list.get(0);
        List<Integer> rest = list.subList(1,list.size());
        List<List<Integer>> subAns = subsets(rest);
        List<List<Integer>> subAns2 = insertAll(fst, subAns);
        return concat(subAns, subAns2);
    }

    static List<List<Integer>> insertAll(Integer fst,
                                         List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(fst);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a,
                                      List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(4);list.add(9);list.add(5);
        List<List<Integer>> result = App.subsets(list);

        for(List<Integer> r : result){
            for(Integer ri :r){
                System.out.printf(String.valueOf(ri));
            }
            System.out.println();
        }
    }
}
