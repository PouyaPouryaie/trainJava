package graph.ex5;

import java.util.*;

public class DGraphReach extends DGraphWtAL {

    public DGraphReach(int size) {
        super(size);
    }

    public static Boolean findTarget = Boolean.FALSE;


    int[] reach(int x, int y) {
        reset(-1);
        Stack<Node> stack = new Stack<>();
        mark[x] = 1;
        Node node = new Node(x);
        findTarget = Boolean.FALSE;
        for (GNode list = OutAL[x]; list != null && list.weight != 0; list = list.next) {
            if (mark[list.nbr] == -1 && !findTarget) {
                mark[list.nbr] = 1;
                path(list, stack, y);
                stack.add(new Node(list.nbr));
            }
        }
        stack.add(node);

        int[] edges = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            edges[i] = stack.pop().vertex;
            i++;
        }
        return edges;
    }


    private void path(GNode node, List<Node> stack, int target) {
        for (GNode list = OutAL[node.nbr]; list != null && list.weight != 0; list = list.next) {
            if (list.nbr == target) {
                Node temp = new Node(list.nbr);
                stack.add(temp);
                findTarget = Boolean.TRUE;
                break;
            } else if (findTarget) {
                break;
            } else if (mark[list.nbr] == -1) {
                mark[list.nbr] = 1;
                path(list, stack, target);
                stack.add(new Node(list.nbr));
            }
        }
    }

    private class Node {
        int vertex;
        Node next;

        Node(int index) {
            vertex = index;
            next = null;
        }
    }

}
