package normaltrain.codetrain.leetcode;

import java.util.*;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(graph.length);
        Map<Integer, Integer> storeRoute = new HashMap<>();
        int nextRoute = 0;
        int indexRoute = 0;
        int cacheRoute = 0;
        int indexCache = 0;
        int routeCache = 0 ;
        boolean isEnd = false;
        List<List<Integer>> result = new ArrayList<>();
        indexCache = indexRoute;
        while (true) {
            boolean isContinue = true;
            List<Integer> data = new ArrayList<>();
            if(graph.length == indexCache){
                break;
            }
            for (int i = indexRoute; i < graph.length; i++) {
                data.add(i);
                for (int j = nextRoute; j < graph[i].length; j++) {
                    if (Objects.nonNull(graph[i][j])) {
                        int value = graph[i][j];
                        storeRoute.put(i, value);
                    } else {
                        isContinue = false;
                    }
                    break;
                }
                if (isContinue) {
                    cacheRoute = storeRoute.get(i);
                }
                break;
            }
            if (isContinue) {
                indexRoute = cacheRoute;
                nextRoute = 0;
            } else {
                result.add(data);
                cacheRoute += 1;
                indexRoute = indexCache;
            }
            if(graph[indexRoute].length-1 < cacheRoute){
                indexCache += 1;
                cacheRoute = 0;
                nextRoute = 0;
                indexRoute = indexCache;
            }
        }
        System.out.println("done");
    }
}
