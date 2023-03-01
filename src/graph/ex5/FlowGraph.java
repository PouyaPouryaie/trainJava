package graph.ex5;

public class FlowGraph {

    DGraphReach residual;
    DGraphWtAL network;
    int source;
    int target;

    public FlowGraph(DGraphWtAL graph, int s, int t) {
        this.network = graph;
        this.source = s;
        this.target = t;
        residual = new DGraphReach(graph.n);

        for(int i = 0 ; i < graph.n ; i++){
            for (DGraphWtAL.GNode list = graph.OutAL[i]; list != null; list = list.next) {
                if(list.mark > 0){
                    residual.addEdge(i, list.nbr, (list.weight - list.mark), 0);
                    residual.addEdge(list.nbr, i, (list.mark), 0);
                }else{
                    residual.addEdge(i, list.nbr, (list.weight), 0);
                }
            }
        }
    }
}
