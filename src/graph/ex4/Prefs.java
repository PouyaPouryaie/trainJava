package graph.ex4;

import java.util.ArrayList;
import java.util.List;

public class Prefs extends Voting {

    public Prefs(int n, int m) {
        super(n, m);
    }

    public void prefList() {

        int comps;

        //first step: define graph and find SCC,so create graph object of kosoraju class
        Kosoraju sccGraph = new Kosoraju(rows);

        //second step: Construct a directed graph G, where each vertex represents an item being ranked
        for(int i = 0; i<rows-1;i++){
            for(int j = i+1; j<rows;j++){
                int point = 0;
                for(int k = 0 ; k < cols ; k++){
                    point = checkPreference(Grid[i][k], Grid[j][k], point);
                }

                if(point>0){
                    sccGraph.addEdge(i,j,1);
                }else if(point<0){
                    sccGraph.addEdge(j,i,1);
                }else {
                    sccGraph.addEdge(i,j,1);
                    sccGraph.addEdge(j,i,1);
                }
            }
        }

        //third step: find SCC in graph and return number of SCC
        comps = sccGraph.SCC();

        //fourth step: define an Array in order to store list of vertex of each SCC group that There found at previous step.
        Node[] nodes = new Node[comps];
        for(int i = 0 ; i < comps; i++){
            Node node = new Node(i);
            for(int j=0; j < rows;j++){
                if(sccGraph.mark[j]==(i+1)){
                    node.addSCCList(j);
                }
            }
            nodes[i] = node;
        }


        //fifth step: build G'
        DGraphTopo dGraphTopo = new DGraphTopo(comps);

        for(int i = 0 ; i < nodes.length-1; i++){
            for(int vertexSource: nodes[i].SCCList){
                for(int j = 0 ; j < nodes.length-1; j++){
                    if(i != j){
                        for(int vertexDestination: nodes[j].SCCList) {
                            if (sccGraph.testEdge(vertexSource, vertexDestination)) {

                                boolean found = false;
                                for (DGraphWtAL.GNode list = dGraphTopo.OutAL[nodes[i].vertex]; list != null && !found; list = list.next) {
                                    if (list.nbr == nodes[j].vertex) {
                                        found = true;
                                    }
                                }
                                if(!found){
                                    dGraphTopo.addEdge(nodes[i].vertex, nodes[j].vertex, 1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        //sixth step: topological order of G'
        int[] ints = dGraphTopo.topoSort();

        //seventh step: Output the SCCs in topological order
        for(int i = 0; i < ints.length; i++){
            List<Integer> sccList = nodes[ints[i]].getSCCList();
            for (int vertex: sccList){
                System.out.printf(vertex + " ");
            }
            System.out.println();
        }
    }

    private int checkPreference(int first, int second, int point){
        if(first < second){
            point++;
        }else if(second < first) {
            point--;
        }
        return point;
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
