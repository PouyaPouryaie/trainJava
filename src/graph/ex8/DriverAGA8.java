package graph.ex8;
//********************************
// DriverAGA8.java
//********************************

import java.util.Scanner;

public class DriverAGA8
{
    
    public static void main(String[] args)
    {
	int n, m, x, y;


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of vertices: ");
	n = scan.nextInt();
	System.out.print("Number of edges: ");
	m = scan.nextInt();
	Between Graph = new Between(n);
//	System.out.println("Enter edges (pairs of indices):");
//	for(int i=0;i<m;i++) {
//	    x = scan.nextInt();
//	    y = scan.nextInt();
//	    Graph.addEdge(x,y,1);
//	}

	Graph.addEdge(0, 1, 1);
	Graph.addEdge(1, 2, 1);
	Graph.addEdge(1, 3, 1);
	Graph.addEdge(2, 4, 1);
	Graph.addEdge(3, 4, 1);

	Graph.betFind();
	
	System.out.println(Graph);

	
    }   

}
