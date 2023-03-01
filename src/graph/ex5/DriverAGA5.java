//********************************
// DriverAGA5.java
//********************************
package graph.ex5;

import java.util.Scanner;
public class DriverAGA5
{
    
    public static void main(String[] args)
    {
	int n, m, x, y, cap, f, s, t;
	Boolean test;
	int order[];


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of vertices: ");
	n = scan.nextInt();
	System.out.print("Number of edges: ");
	m = scan.nextInt();
	System.out.print("Specify source vertex: ");
	s = scan.nextInt();
	System.out.print("Specify target vertex: ");
	t = scan.nextInt();	
	DGraphWtAL Graph = new DGraphWtAL(n);
	System.out.println("Enter edges (pairs of indices, capacity, and initial flow):");
//	for(int i=0;i<m;i++) {
//	    x = scan.nextInt();
//	    y = scan.nextInt();
//	    cap = scan.nextInt();
//	    f = scan.nextInt();
//	    Graph.addEdge(x,y,cap,f);
//	}

		Graph.addEdge(0,1,5,3);
		Graph.addEdge(0,2,8,0);
		Graph.addEdge(1,3,3,0);
		Graph.addEdge(1,4,3,3);
		Graph.addEdge(2,4,2,0);
		Graph.addEdge(2,5,4,0);
		Graph.addEdge(3,5,7,0);
		Graph.addEdge(4,5,4,3);

	FlowGraph fpair = new FlowGraph(Graph, s, t);

	System.out.println("Flow network");
	System.out.println(fpair.network);
	System.out.println("Residual graph");
	System.out.println(fpair.residual);

	order = fpair.residual.reach(s, t);
	
	if(order!=null) {
	    for(int i=0;order[i]!=t;i++) {
		System.out.print(order[i] + " ");
	    }
	    System.out.print(t + "\n");
	}
    }   

}
