package graph.ex7;
//********************************
// DriverAGA7.java
//********************************

import java.util.Scanner;

public class DriverAGA7
{
    
    public static void main(String[] args)
    {
	int n, m, x, y, cutsize, times, pieces;


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of vertices: ");
	n = scan.nextInt();
	System.out.print("Number of edges: ");
	m = scan.nextInt();
	Karger Graph = new Karger(n,m);
	System.out.println("Enter edges (pairs of indices):");
	for(int i=0;i<m;i++) {
	    x = scan.nextInt();
	    y = scan.nextInt();
	    Graph.addEdge(x,y);
	}
	System.out.print("Number of components wanted: ");
	pieces = scan.nextInt();
	System.out.print("Number of algorithm repetitions: ");
	times = scan.nextInt();
	System.out.print("\n");
	

	cutsize = Graph.minCut(pieces,times);
	System.out.println(cutsize + " edge(s) crossing cut(s)\n");

	System.out.println(Graph);
	
	
    }

}
