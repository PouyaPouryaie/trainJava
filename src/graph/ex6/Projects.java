package graph.ex6;

import java.util.*;

public class Projects {

    private int numberOfProject;
    private Map<Integer, Node> projectNodes = new HashMap<>();
    private Set<Node> preRequiredNodes = new HashSet<>();
    private int source;
    private int target;
    private DGraphWtAL residualGraph;
    private int[] selectedProjects;


    public Projects(int n) {
        numberOfProject = n;
        selectedProjects = new int[numberOfProject];
        source = n;
        target = n + 1;
    }

    public void addPrereq(int i, int j){
        if(projectNodes.containsKey(i) && projectNodes.containsKey(j)){
            projectNodes.get(j).addPreRequired(projectNodes.get(i));
            preRequiredNodes.add(projectNodes.get(i));
        }
    }

    public void addProfit(int project, int profit){
        Node newProject = new Node(project, profit);
        projectNodes.put(project, newProject);
    }

    public int[] projSelect(){
        DGraphWtAL graph = new DGraphWtAL(numberOfProject +2);
        buildDGraphWtAL(graph);
        GraphFlow fpair = new GraphFlow(graph,  this.source, this.target);
        fpair.FordFulk();
        residualGraph = fpair.residual;
        readToFindCandidateProject(residualGraph);
        return selectedProjects;
    }

    private void readToFindCandidateProject(DGraphWtAL graph){
        graph.reset(-1);
        for (DGraphWtAL.GNode node = graph.InAL[this.target]; node != null; node = node.next) {
            if(residualGraph.mark[node.nbr] == -1 && node.weight != 0){
                residualGraph.mark[node.nbr] = 1;
                selectedProjects[node.nbr] = 1;
                path(node, selectedProjects);
            }
        }
    }

    private void path(DGraphWtAL.GNode node, int[] selectProject) {
        for (DGraphWtAL.GNode list = residualGraph.InAL[node.nbr]; list != null; list = list.next) {
            if(preRequiredNodes.contains(projectNodes.get(list.nbr))){
                residualGraph.mark[list.nbr] = 1;
                selectProject[list.nbr] = 1;
            }
        }
    }

    private void buildDGraphWtAL(DGraphWtAL graph){

        int maxWeight = 1;

        for(Node node: projectNodes.values()){
            if(!preRequiredNodes.contains(node)){
                maxWeight += node.weight;
            }
        }

        for(Node n : preRequiredNodes){
            graph.addEdge(this.source, n.name, n.weight, 0);
        }

        for(Node n: projectNodes.values()){
            if(n.nodes.size() > 0){
                for(Node pre : n.nodes){
                    graph.addEdge(pre.name, n.name, maxWeight, 0);
                }
                graph.addEdge(n.name, this.target, n.weight, 0);
            }
        }

    }

    static class Node {
        int name;
        int weight;
        List<Node> nodes = new ArrayList<>();

        public Node(int name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public void addPreRequired(Node n){
            this.nodes.add(n);
        }
    }
}
