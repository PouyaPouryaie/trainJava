package graph.ex4;

import java.util.Stack;

public class Kosoraju extends DGraphWtAL {

    public Kosoraju(int size) {
        super(size);
    }

    public int SCC() {
        reset(-1);
        Stack<Node> stack = new Stack<>();
        int c = 0;

        for (int index = 0; index < n; index++) {
            if (mark[index] == -1) {
                mark[index] = 1;
                Node node = new Node(index);
                for (GNode list = OutAL[index]; list != null; list = list.next) {
                    if (mark[list.nbr] == -1) {
                        mark[list.nbr] = 1;
                        DFS(list, stack);
                        stack.add(new Node(list.nbr));
                    }
                }
                stack.add(node);
            }
        }

        reset(-1);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (mark[node.getName()] == -1) {
                c += 1;
                mark[node.getName()] = c;
                DFSC(node, c);
            }
        }

        return c;
    }

    private class Node {
        private final int name;

        Node(int name) {
            this.name = name;
        }

        public int getName() {
            return name;
        }
    }

    private void DFSC(Node node, int c) {
        for (GNode list = InAL[node.getName()]; list != null; list = list.next) {
            if (mark[list.nbr] == -1) {
                mark[list.nbr] = c;
                DFSC(new Node(list.nbr), c);
            }
        }
    }

    private void DFS(GNode node, Stack<Node> stack) {
        for (GNode list = OutAL[node.nbr]; list != null; list = list.next) {
            if (mark[list.nbr] == -1) {
                mark[list.nbr] = 1;
                DFS(list, stack);
                stack.add(new Node(list.nbr));
            }
        }
    }
}
