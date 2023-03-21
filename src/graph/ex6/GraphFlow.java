package graph.ex6;

public class GraphFlow {

    DGraphWtAL network;
    DGraphReach residual;
    int source;
    int target;

    public GraphFlow(DGraphWtAL graph, int s, int t) {
        network = graph;
        source = s;
        target = t;
        residual = new DGraphReach(graph.n);
        
        for(int i = 0 ; i < graph.n ; i++){
            for (DGraphWtAL.GNode list = graph.OutAL[i]; list != null; list = list.next) {
                if(list.mark > 0){
                    residual.addEdge(i, list.nbr, list.weight - list.mark, 0);
                    residual.addEdge(list.nbr, i, list.mark, 0);
                }else{
                    residual.addEdge(i, list.nbr, list.weight, 0);
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
                            residual.addEdge(index, node.nbr, node.weight - node.mark, 0);
                            residual.addEdge(node.nbr, index, node.mark, 0);
                        }else{
                            residual.addEdge(index, node.nbr, node.weight, 0);
                        }
                    }
                }
            }else {
                canMove = false;
            }
        }
    }
}
