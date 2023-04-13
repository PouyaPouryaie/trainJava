package graph.ex9;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EBetween extends GraphWtAL {

    private float[] btwn;
    private int numberOfEdge;
    private int capacity = 0;

    private float[] vertexBtwn;
    private int[] distance;
    private int[] parent;
    private List<Edge> discoveryEdges = new ArrayList<>();

    private boolean removeEdge = false;

    public EBetween(int size, int m) {
        super(size);
        numberOfEdge = m;
        btwn = new float[numberOfEdge]; //edge
        for (int i = 0; i < numberOfEdge; i++) {
            btwn[i] = 0;
        }
        vertexBtwn = new float[size]; //vertex
        for (int i = 0; i < size; i++) {
            vertexBtwn[i] = 0;
        }

        distance = new int[size];
        parent = new int[size];
    }

    public void addEdge(int x, int y) {
        if (capacity < numberOfEdge) {
            super.addEdge(x, y, capacity);
        }
        capacity++;
    }

    public void betFind() {
        for (int nodeIndex = 0; nodeIndex < this.n; nodeIndex++) {
            discoveryEdges = new ArrayList<>();
            float[] vertexBtwnInEachRound = new float[this.n];
            reset(Integer.MAX_VALUE);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < this.n; i++) {
                distance[i] = Integer.MAX_VALUE;
                parent[i] = 1;
                vertexBtwnInEachRound[i] = 0;
            }
            distance[nodeIndex] = 0;
            q.add(nodeIndex);
            mark[nodeIndex] = 1;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (GNode target = AdjList[node]; target != null; target = target.next) {
                    if (distance[target.nbr] == Integer.MAX_VALUE) {
                        mark[target.nbr] = 1;
                        distance[target.nbr] = distance[node] + 1;
                        q.add(target.nbr);
                        Edge edge = new Edge(node, target.nbr);
                        discoveryEdges.add(edge);
                    } else if (distance[target.nbr] == distance[node] + 1) {
                        mark[target.nbr] = 1;
                        parent[target.nbr] = parent[target.nbr] + 1;
                        Edge edge = new Edge(node, target.nbr);
                        discoveryEdges.add(edge);
                    }
                }
            }

            vertexBtwnInEachRound[nodeIndex] = bpost(nodeIndex, vertexBtwnInEachRound);

            for (int i = 0; i < this.n; i++) {
                vertexBtwn[i] = vertexBtwn[i] + vertexBtwnInEachRound[i];
            }
        }

        score();

    }

    public void cluster(float value) {

        for (int i = 0; i < this.numberOfEdge; i++) {
            if (btwn[i] >= value) {
                removeEdge = true;
                break;
            }
        }

        while (removeEdge) {

            float maxBetweenness = Float.MIN_VALUE;
            int edgeIndex = 0;
            for (int i = 0; i < this.numberOfEdge; i++) {
                if (btwn[i] >= value && btwn[i] >= maxBetweenness) {
                    edgeIndex = i;
                    maxBetweenness = btwn[i];
                }
            }

            for (GNode target = AdjList[edgeIndex]; target != null; target = target.next) {
                if (target.weight == edgeIndex) {
                    super.delEdge(edgeIndex, target.nbr);
                }
            }

            for (int i = 0; i < numberOfEdge; i++) {
                btwn[i] = 0;
            }

            for (int i = 0; i < super.n; i++) {
                vertexBtwn[i] = 0;
            }

            distance = new int[super.n];
            parent = new int[super.n];
            discoveryEdges = new ArrayList<>();

            this.betFind();

            removeEdge = false;

            for (int i = 0; i < this.numberOfEdge; i++) {
                if (btwn[i] >= value) {
                    removeEdge = true;
                    break;
                }
            }
        }

        findComponent();

    }

    private void findComponent() {
        Queue<Integer> q = new LinkedList<>();
        reset(Integer.MAX_VALUE);
        int componentNumber = 0;
        for (int i = 0; i < super.n; i++) {
            if (mark[i] == Integer.MAX_VALUE) {
                componentNumber = componentNumber + 1;
                mark[i] = componentNumber;
                q.add(i);
                while (!q.isEmpty()) {
                    int edge = q.poll();
                    for (GNode target = AdjList[edge]; target != null; target = target.next) {
                        if (mark[target.nbr] == Integer.MAX_VALUE) {
                            mark[target.nbr] = mark[edge];
                            q.add(target.nbr);
                        }
                    }
                }
            }
        }
    }

    private void score() {
        float subtractNumber = (2 * this.n) - 1;
        float dividedNumber = (float) Math.pow(this.n, 2) - (3 * this.n) + 2;
        for (int i = 0; i < this.n; i++) {
            vertexBtwn[i] = (vertexBtwn[i] - subtractNumber) / dividedNumber;
        }
        for (int i = 0; i < this.numberOfEdge; i++) {
            btwn[i] = btwn[i] / ((float) Math.pow(this.n, 2) - (this.n));
        }
    }

    private float bpost(int vertex, float[] vertexBtwnInEachRound) {
        if (vertexBtwnInEachRound[vertex] == 0) {
            vertexBtwnInEachRound[vertex] = 1;
            for (GNode target = AdjList[vertex]; target != null; target = target.next) {
                for (Edge edge : discoveryEdges) {
                    if (edge.source == vertex && edge.target == target.nbr) {
                        float bp = bpost(target.nbr, vertexBtwnInEachRound);
                        vertexBtwnInEachRound[vertex] = vertexBtwnInEachRound[vertex] + bp;
                        btwn[target.weight] = btwn[target.weight] + bp;
                    }
                }
            }
        }
        return vertexBtwnInEachRound[vertex] / parent[vertex];
    }

    @Override
    public String toString() {
        StringBuilder score = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        for (int i = 0; i < this.numberOfEdge; i++) {
            score.append(df.format(btwn[i])).append("\t");
        }
        return super.toString() + score;
    }


    private class Edge {
        private int source;
        private int target;

        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }

        public int getSource() {
            return source;
        }

        public int getTarget() {
            return target;
        }
    }
}
