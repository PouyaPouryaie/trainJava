package graph.ex5;

import java.util.*;

public class DGraphReach extends DGraphWtAL{

    public DGraphReach(int size) {
        super(size);
    }

    public static Boolean findTarget = Boolean.FALSE;


    int[] reach(int x, int y){
        reset(-1);
        Stack<Node> stack = new Stack<>();
        mark[x] = 1;
        Node node = new Node(x);
        findTarget = Boolean.FALSE;
        for (GNode list = OutAL[x]; list != null && list.weight != 0; list = list.next) {
            if (mark[list.nbr] == -1 && !findTarget) {
                mark[list.nbr] = 1;
                DFS(list, stack, y);
                stack.add(new Node(list.nbr));
            }
        }
        stack.add(node);

        int[] edges = new int[stack.size()];
        int i = 0;
        while (!stack.empty()){
            edges[i] = stack.pop().vertex;
            i++;
        }
        return edges;
    }


    private void DFS(GNode node, List<Node> stack, int target) {
        for (GNode list = OutAL[node.nbr]; list != null && list.weight != 0; list = list.next) {
            if(list.nbr == target){
                Node temp = new Node(list.nbr);
                stack.add(temp);
                findTarget = Boolean.TRUE;
                break;
            }
            else if(findTarget){
                break;
            }
            else if (mark[list.nbr] == -1) {
                mark[list.nbr] = 1;
                DFS(list, stack, target);
                stack.add(new Node(list.nbr));
            }
        }
    }




//    int[] reach(int x, int y){
//        Queue<Node> queue = new ArrayDeque<>();
//        reset(-1);
//        mark[x] = 1;
//        Node s = new Node(x);
//        queue.add(s);
//        List<Integer> numbers = new ArrayList<>();
//
//        Node end = null;
//        while (queue != null) {
//            Node item = queue.poll();
//            if(mark[y] == -1){
//                for (GNode list = OutAL[item.vertex]; list != null; list = list.next) {
//                    if (mark[list.nbr] == -1) {
//                        mark[list.nbr] = 1;
//                        Node temp = new Node(list.nbr);
//                        queue.add(temp);
//                        temp.next = item;
//                    }
//                }
//            }
//            else {
//                end = item;
//            }
//        }
//        List<Integer> path = path(numbers, end);
//        int[] edges = new int[path.size()];
//        for(int i = 0; i < path.size(); i++) edges[i] = path.get(i);
//        return edges;
//    }
//
//    private List<Integer> path(List<Integer> path, Node edge){
//        List<Integer> temp = new ArrayList<>();
//        if(edge.next != null){
//            temp = path(path, edge.next);
//        }
//        temp.add(edge.vertex);
//        return temp;
//    }
//
//
//    private void DFS(GNode node, Stack<Node> stack) {
//        for (GNode list = OutAL[node.nbr]; list != null; list = list.next) {
//            if (mark[list.nbr] == -1) {
//                mark[list.nbr] = 1;
//                DFS(list, stack);
//                stack.add(new Node(list.nbr));
//            }
//        }
//    }

    private class Node {
        int vertex;
        Node next;

        Node(int index) {
            vertex = index;
            next = null;
        }
    }
}
