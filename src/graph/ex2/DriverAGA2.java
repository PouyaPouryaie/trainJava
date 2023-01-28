//********************************
// DriverAGA2.java
//********************************
package graph.ex2;

import graph.ex2.DGraphTopo;

import java.util.Scanner;

public class DriverAGA2
{
    
    public static void main(String[] args)
    {
	int n, m, x, y, wt;
	Boolean test;
	int order[];


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of vertices: ");
	n = scan.nextInt();
	System.out.print("Number of edges: ");
	m = scan.nextInt();
	DGraphTopo Graph = new DGraphTopo(n);
	System.out.println("Enter edges (pairs of indices and weight):");
	for(int i=0;i<m;i++) {
	    x = scan.nextInt();
	    y = scan.nextInt();
	    wt = scan.nextInt();
	    Graph.addEdge(x,y,wt);
	}

//	Graph.addEdge(0,1,1);
// 	Graph.addEdge(1,2,1);
// 	Graph.addEdge(1,4,1);
//	Graph.addEdge(0,2,1);
//	Graph.addEdge(2,3,1);
//	Graph.addEdge(2,4,1);
//	Graph.addEdge(3,5,1);
//	Graph.addEdge(4,5,1);

	System.out.println(Graph);

	order = Graph.topoSort();
	for(int i=0;i<n;i++) {
	    System.out.print(order[i] + " ");
	}
	    System.out.print("\n");

    }   

}
