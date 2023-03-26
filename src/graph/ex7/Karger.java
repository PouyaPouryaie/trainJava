package graph.ex7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Karger extends GraphWtAL {

    private int numberEdges;
    private Edge[] edges;
    private int index = 0;
    private Random rand = new Random();

    public Karger(int numberOfVertices, int numberOfEdges) {
        super(numberOfVertices);
        this.edges = new Edge[numberOfEdges];
    }

    public void addEdge(int x, int y) {
        super.addEdge(x, y, 1);
        if(index < edges.length){
            Edge edge = new Edge(x,y);
            edges[index] = edge;
            index++;
        }
    }

    public int minCut(int pieces, int times){

        int nodeSize = super.n;
        int edgeSize = edges.length;
        int candidateMinCut = Integer.MAX_VALUE;
        Edge[] candidateEdge = new Edge[edgeSize];
        UnionFind candidateFind = new UnionFind(nodeSize);
        Edge[] baseEdges = edges;

        for(int i = 0; i < times; i++){
            nodeSize = super.n;
            UnionFind unionFind = new UnionFind(nodeSize);
            numberEdges = edgeSize;
            Edge[] edges = baseEdges;
            while (nodeSize > pieces){
                int index = rand.nextInt(numberEdges-1);
                Edge edge = edges[index];
                if(unionFind.find(edge.source) != unionFind.find(edge.target)){
                    unionFind.union(edge.source, edge.target);
                    nodeSize = nodeSize - 1;
                }
                if(index != numberEdges){
                    Edge temp = edges[index];
                    edges[index] = edges[numberEdges - 1];
                    edges[numberEdges - 1] = temp;
                }
                numberEdges = numberEdges - 1;
            }

            int number = 0;
            numberEdges = edgeSize;
            while (number < numberEdges){
                Edge edge = edges[number];
                if(unionFind.find(edge.source) == unionFind.find(edge.target)){
                    Edge temp = edges[number];
                    edges[number] = edges[numberEdges - 1];
                    edges[numberEdges - 1] = temp;
                    numberEdges = numberEdges - 1;
                }else{
                    number = number + 1;
                }
            }

            if(candidateMinCut > numberEdges){
                candidateMinCut = numberEdges;
                candidateEdge = edges;
                candidateFind = unionFind;
            }
        }

        Map<Integer, Integer> parentNumber = new HashMap<>();
        int markIndex = 0;
        for(int j = 0 ; j < candidateFind.size; j++){
            int parent = candidateFind.rep[j];
            if(!parentNumber.containsKey(parent)){
                parentNumber.put(parent, markIndex);
                markIndex++;
            }
        }

        for(int parent: parentNumber.keySet()){
            for(int j = 0; j < candidateFind.size; j++){
                if(parent == candidateFind.rep[j]){
                    super.mark[j] = parentNumber.get(parent);
                    System.out.printf(j + " ");
                }
            }
            System.out.println();
        }

        return candidateMinCut;
    }

    class Edge {
        int source;
        int target;

        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
    }
}
