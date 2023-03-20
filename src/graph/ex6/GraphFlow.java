package graph.ex6;

public class GraphFlow {
    int source;
    int target;
    DGraphWtAL network;
    DGraphReach residual;

    public GraphFlow(DGraphWtAL graph, int s, int t) {
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

    public void FordFulk(){
        boolean canMove = true;
        while (canMove){
            int[] reach = residual.reach(source, target);
            if(reach != null && reach.length > 0){
                int minValue = Integer.MAX_VALUE;
                for(int i =0 ; i < reach.length-1; i++){
                    for (DGraphWtAL.GNode node = residual.OutAL[reach[i]]; node != null; node = node.next) {
                        if(node.nbr == reach[i+1]){
                           if(node.weight < minValue){
                               minValue = node.weight;
                           }
                            break;
                        }
                    }
                }
                for(int i =0 ; i < reach.length; i++){
                    for (DGraphWtAL.GNode node = network.OutAL[reach[i]]; node != null; node = node.next) {
                        if(node.nbr == reach[i+1]){
                            node.mark += minValue;
                            break;
                        }
                    }
                }

                residual = new DGraphReach(network.n);
                for(int index = 0 ; index < network.n ; index++){
                    for (DGraphWtAL.GNode node = network.OutAL[index]; node != null; node = node.next) {
                        if(node.mark > 0){
                            int newValue = node.weight - node.mark;
                            residual.addEdge(index, node.nbr, (newValue), 0);
                            residual.addEdge(node.nbr, index, (node.mark), 0);
                        }else{
                            residual.addEdge(index, node.nbr, (node.weight), 0);
                        }
                    }
                }
            }else {
                canMove = false;
            }
        }
    }
}
