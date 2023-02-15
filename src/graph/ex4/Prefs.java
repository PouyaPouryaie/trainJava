package graph.ex4;

import java.util.ArrayList;
import java.util.List;

public class Prefs extends Voting {

    public Prefs(int n, int m) {
        super(n, m);
    }

    public void prefList() {

        //create graph object of kosoraju class in order to find SCC
        Kosoraju G = new Kosoraju(rows);

        buildKosorajuGraph(G);

        //find SCC in graph and return number of SCC
        int comps = G.SCC();

        //define an Array in order to store list of vertex of each SCC group that There were found at previous step.
        Node[] nodes = new Node[comps];
        for (int i = 0; i < comps; i++) {
            Node node = new Node(i);
            for (int j = 0; j < rows; j++) {
                if (G.mark[j] == (i + 1)) {
                    node.addSCCList(j);
                }
            }
            nodes[i] = node;
        }


        //build G'
        DGraphTopo gTopo = buildTopoGraph(G, nodes);

        //topological order of G'
        int[] order = gTopo.topoSort();

        //output the SCCs in topological order
        for (int j : order) {
            nodes[j].getSCCList().forEach(integer -> System.out.printf(integer + " "));
            System.out.println();
        }
    }

    //iterate on Voting class to construct a directed graph G
    private void buildKosorajuGraph(Kosoraju G){

        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < rows; j++) {
                int rank = 0;
                for (int k = 0; k < cols; k++) {
                    rank = checkItemBetweenToVoter(Grid[i][k], Grid[j][k], rank);
                }

                if (rank > 0) {
                    G.addEdge(i, j, 1);
                } else if (rank < 0) {
                    G.addEdge(j, i, 1);
                } else {
                    G.addEdge(i, j, 1);
                    G.addEdge(j, i, 1);
                }
            }
        }
    }

    //check preferences of item based on user
    private int checkItemBetweenToVoter(int first, int second, int rank) {
        if (first < second) {
            rank++;
        } else if (second < first) {
            rank--;
        }
        return rank;
    }

    //check all node of kosoraju graph to find edge between 2 SCCs in order to build G'
    private DGraphTopo buildTopoGraph(Kosoraju G, Node[] nodes){

        DGraphTopo graph = new DGraphTopo(nodes.length);

        for (int i = 0; i < nodes.length - 1; i++) {
            for (int vertexSource : nodes[i].SCCList) {
                for (int j = 0; j < nodes.length - 1; j++) {
                    if (i != j) {
                        for (int vertexDestination : nodes[j].SCCList) {
                            if (G.testEdge(vertexSource, vertexDestination)) {

                                boolean found = false;
                                for (DGraphWtAL.GNode list = graph.OutAL[nodes[i].vertex]; list != null && !found; list = list.next) {
                                    if (list.nbr == nodes[j].vertex) {
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    graph.addEdge(nodes[i].vertex, nodes[j].vertex, 1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return graph;
    }

    private static class Node {
        private final int vertex;
        private List<Integer> SCCList = new ArrayList<>();

        Node(int vertex) {
            this.vertex = vertex;
        }

        public int getVertex() {
            return vertex;
        }

        public List<Integer> getSCCList() {
            return SCCList;
        }

        public void addSCCList(int vertex) {
            SCCList.add(vertex);
        }
    }
}
