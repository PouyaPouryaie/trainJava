package graph.ex2;

import java.util.ArrayDeque;
import java.util.Queue;

public class DGraphTopo extends DGraphWtAL {

    public DGraphTopo(int size) {
        super(size);
    }

    public int[] topoSort() {

        GNode vertex;
        Queue<Node> queue = new ArrayDeque<>();
        int[] counter = new int[n];
        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (GNode list = InAL[i]; list != null; list = list.next) {
                j++;
            }
            if (j == 0) {
                queue.add(new Node(i));
            }
            counter[i] = j;
        }

        int i = 0;
        while (!queue.isEmpty()) {
            Node index = (Node) queue.poll();
            order[i] = index.vertex;
            i++;
            for (GNode list = OutAL[index.vertex]; list != null; list = list.next) {
                counter[list.nbr]--;
                if (counter[list.nbr] == 0) {
                    queue.add(new Node(list.nbr));
                }
            }
        }

        return order;
    }

    private static class Node {
        int vertex;

        Node(int vertex) {
            this.vertex = vertex;
        }
    }
}
