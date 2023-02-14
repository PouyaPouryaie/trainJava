package graph.ex4;

public class DGraphTopo extends DGraphWtAL {

    public DGraphTopo(int size) {
        super(size);
    }

    public int[] topoSort() {

        Node queue = null;
        Node tail = null;
        Node item = null;
        int[] counter = new int[n];
        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (GNode list = InAL[i]; list != null; list = list.next) {
                j++;
            }
            if (j == 0) {
                if (queue == null) {
                    queue = new Node(i);
                    item = queue;
                    tail = queue;
                } else {
                    tail.setNext(new Node(i));
                    tail = tail.getNext();
                }
            }
            counter[i] = j;
        }

        int i = 0;
        while (queue != null) {
            item = queue;
            order[i] = item.getVertex();
            i++;
            for (GNode list = OutAL[item.getVertex()]; list != null; list = list.next) {
                counter[list.nbr]--;
                if (counter[list.nbr] == 0) {
                    tail.setNext(new Node(list.nbr));
                    tail = tail.getNext();
                }
            }
            queue = queue.getNext();
        }

        return order;
    }

    private static class Node {
        private final int vertex;
        private Node next;

        Node(int vertex) {
            this.vertex = vertex;
        }

        public int getVertex() {
            return vertex;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
