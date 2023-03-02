package graph.ex5;

public class FlowGraph {
    int source;
    int target;
    DGraphWtAL network;
    DGraphReach residual;

    public FlowGraph(DGraphWtAL graph, int s, int t) {
        this.source = s;
        this.target = t;
        this.network = graph;
        residual = new DGraphReach(graph.n);
        for(int index = 0 ; index < graph.n ; index++){
            for (DGraphWtAL.GNode node = graph.OutAL[index]; node != null; node = node.next) {
                if(node.mark > 0){
                    int newValue = node.weight - node.mark;
                    residual.addEdge(index, node.nbr, (newValue), 0);
                    residual.addEdge(node.nbr, index, (node.mark), 0);
                }else{
                    residual.addEdge(index, node.nbr, (node.weight), 0);
                }
            }
        }
    }
}
