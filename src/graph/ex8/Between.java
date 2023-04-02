package graph.ex8;

import normaltrain.interfacetrain.A;

import java.util.*;

public class Between extends GraphWtAL{

    private double[] btwn;
    private int[] distance;
    private int[] parent;
    private List<Edge> discoveryEdges = new ArrayList<>();
    public Between(int size) {
        super(size);
        btwn = new double[size];
        for(int i = 0 ; i < size ; i++){
            btwn[i] = 0;
        }
        distance = new int[size];
        parent = new int[size];
    }

    public void betFind(){
        for(int nodeIndex = 0 ; nodeIndex < this.n; nodeIndex++){
            discoveryEdges = new ArrayList<>();
            double[] btwnInEachRound = new double[this.n];
            reset(Integer.MAX_VALUE);
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0 ; i < this.n ; i++){
                distance[i] = Integer.MAX_VALUE;
                parent[i] = 1;
                btwnInEachRound[i] = 0;
            }
            distance[nodeIndex] = 0;
            q.add(nodeIndex);
            mark[nodeIndex] = 1;
            while (!q.isEmpty()){
                int node = q.poll();
                for(GNode target = AdjList[node]; target != null; target = target.next){
                    if(distance[target.nbr] == Integer.MAX_VALUE){
                        mark[target.nbr] = 1;
                        distance[target.nbr] = distance[node] + 1;
                        q.add(target.nbr);
                        Edge edge = new Edge(node, target.nbr);
                        discoveryEdges.add(edge);
                    }
                    else if(distance[target.nbr] == distance[node] + 1){
                        mark[target.nbr] = 1;
                        parent[target.nbr] = parent[target.nbr] + 1;
                        Edge edge = new Edge(node, target.nbr);
                        discoveryEdges.add(edge);
                    }
                }
            }

            btwnInEachRound[nodeIndex] = bpost(nodeIndex, btwnInEachRound);

            for(int i = 0 ; i < this.n; i++){
                btwn[i] = btwn[i] + btwnInEachRound[i];
            }
        }

        score();

    }

    @Override
    public String toString() {
        StringBuilder score = new StringBuilder();
        for(int i = 0 ; i < this.n; i++){
            score.append(String.format("%.2f", btwn[i])).append("\t");
        }
        String result = super.toString() + "\n";
        return result + score;
    }

    private void score(){
        double subtractNumber = (2 * this.n) - 1;
        double dividedNumber = Math.pow(this.n, 2) - (3 * this.n) + 2;
        for(int i = 0 ; i < this.n; i++){
            btwn[i] = (btwn[i] - subtractNumber) / dividedNumber;
        }
    }

    private double bpost(int vertex, double[] btwnInEachRound){
        if(btwnInEachRound[vertex] == 0){
            btwnInEachRound[vertex] = 1;
            for(GNode target = AdjList[vertex]; target != null; target = target.next){
                for(Edge edge: discoveryEdges){
                    if(edge.source == vertex && edge.target == target.nbr){
                        btwnInEachRound[vertex] = btwnInEachRound[vertex] + bpost(target.nbr, btwnInEachRound);
                    }
                }
            }
        }
        return btwnInEachRound[vertex] / parent[vertex];
    }

    private class Edge{
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

    private class SLLNode {
        int vertex;
        SLLNode next;

        SLLNode(int index) {
            vertex = index;
            next = null;
        }
    }
}
