package graph.ex1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphReach extends GraphWtAL implements Comparator<GraphReach.GNode> {

    public int compare(GNode o1, GNode o2) {
        return Integer.compare(o1.weight, o2.weight);
    }

    public GraphReach(int size) {
        super(size);
    }

    boolean reach(int source, int target) {
        boolean found = false;
        int[] distance = new int[AdjList.length];

        for (int i = 0; i < AdjList.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        PriorityQueue<GNode> priorityQueue = new PriorityQueue<>(AdjList.length, this);

        GNode firstNode = new GNode(source, distance[source]);

        priorityQueue.add(firstNode);

        while (priorityQueue.size() > 0 && !found) {

            GNode node = priorityQueue.poll();

            if (node.nbr == target) {
                found = true;
            }

            mark[node.nbr] = 1;

            if (!found) {
                for (GNode list = AdjList[node.nbr]; list != null; list = list.next) {
                    if (distance[node.nbr] + list.weight < distance[list.nbr]) {
                        distance[list.nbr] = distance[node.nbr] + list.weight;
                        GNode nextNode = new GNode(list.nbr, distance[list.nbr]);
                        priorityQueue.add(nextNode);
                    }
                }
            }
        }

        return found;
    }
}
