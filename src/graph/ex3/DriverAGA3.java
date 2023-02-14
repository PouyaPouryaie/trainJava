//********************************
// DriverAGA2.java
//********************************
package graph.ex3;

import java.util.Scanner;

public class DriverAGA3 {

    public static void main(String[] args) {
        int n, m, x, y, wt;

        int comps;


        Scanner scan = new Scanner(System.in);
        System.out.print("Number of vertices: ");
        n = scan.nextInt();
        System.out.print("Number of edges: ");
        m = scan.nextInt();
        Kosoraju Graph = new Kosoraju(n);
        System.out.println("Enter edges (pairs of indices and weight):");
        for (int i = 0; i < m; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            wt = scan.nextInt();
            Graph.addEdge(x, y, wt);
        }

//        Graph.addEdge(0, 1, 1);
//        Graph.addEdge(1, 4, 1);
//        Graph.addEdge(3, 1, 1);
//        Graph.addEdge(3, 2, 1);
//        Graph.addEdge(3, 4, 1);
//        Graph.addEdge(3, 5, 1);
//        Graph.addEdge(4, 1, 1);
//        Graph.addEdge(4, 2, 1);
//        Graph.addEdge(5, 3, 1);
//        Graph.addEdge(5, 4, 1);
//        Graph.addEdge(2, 0, 1);


        comps = Graph.SCC();
        System.out.println(comps + " strongly connected components");
        System.out.println(Graph);

    }
}
