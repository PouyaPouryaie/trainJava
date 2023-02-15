package graph.ex4;

import java.util.Stack;

public class Kosoraju extends DGraphWtAL {

    public Kosoraju(int size) {
        super(size);
    }

    public int SCC() {
        reset(Integer.MAX_VALUE);
        Stack<Node> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(mark[i] == Integer.MAX_VALUE){
                mark[i] = 1;
                Node node = new Node(i);
                for (GNode list = OutAL[i]; list != null; list = list.next) {
                    if(mark[list.nbr] == Integer.MAX_VALUE){
                        mark[list.nbr] = 1;
                        DFS(list, stack);
                        stack.add(new Node(list.nbr));
                    }
                }
                stack.add(node);
            }
        }

        int c = 0;
        reset(Integer.MAX_VALUE);
        while (!stack.empty()){
            Node node = stack.pop();
            if(mark[node.getVertex()] == Integer.MAX_VALUE){
                c = c + 1;
                mark[node.getVertex()] = c;
                DFSC(node, c);
            }
        }

        return c;
    }

    private void DFSC(Node node, int c){
        for (GNode list = InAL[node.getVertex()]; list != null; list = list.next) {
            if(mark[list.nbr]==Integer.MAX_VALUE){
                mark[list.nbr] = c;
                DFSC(new Node(list.nbr), c);
            }
        }
    }

    private void DFS(GNode node, Stack<Node> stack){
        for (GNode list = OutAL[node.nbr]; list != null; list = list.next) {
            if(mark[list.nbr]==Integer.MAX_VALUE){
                mark[list.nbr] = 1;
                DFS(list, stack);
                stack.add(new Node(list.nbr));
            }
        }
    }

    private static class Node {
        private final int vertex;

        Node(int vertex) {
            this.vertex = vertex;
        }

        public int getVertex() {
            return vertex;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    '}';
        }
    }
}
