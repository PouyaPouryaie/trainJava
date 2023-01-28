package graph.ex1;

public class GraphReachOriginal extends GraphWtAL {

    public GraphReachOriginal(int size) {
        super(size);
    }

    public Boolean reach(int source, int target) {
        GNode edge;

        reset(-1);
        SLLNode queue = new SLLNode(source);
        SLLNode tail = queue;
        SLLNode item = queue;

        mark[source] = 1;
        while (queue != null) {
            item = queue;
            for (edge = AdjList[item.vertex]; edge != null; edge = edge.next) {
                if (mark[edge.nbr] == -1) {
                    mark[edge.nbr] = 1;
                    tail.next = new SLLNode(edge.nbr);
                    tail = tail.next;
                }
            }
            queue = queue.next;
        }

        if (mark[target] == 1) return true;
        else return false;
    }

    private class SLLNode {
        int vertex;
        SLLNode next;

        SLLNode(int index) {
            vertex = index;
            next = null;
        }
    }

}
