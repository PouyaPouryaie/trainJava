package graph.ex1;

//********************************
// DriverAGA1.java
//********************************

import java.util.Scanner;

public class DriverAGA1
{

    public static void main(String[] args)
    {
	int n, m, x, y, wt;
	Boolean test;


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of vertices: ");
	n = scan.nextInt();
	System.out.print("Number of edges: ");
	m = scan.nextInt();
	GraphReach Graph = new GraphReach(n);
	System.out.println("Enter edges (pairs of indices and weight):");
	for(int i=0;i<m;i++) {
	    x = scan.nextInt();
	    y = scan.nextInt();
	    wt = scan.nextInt();
	    Graph.addEdge(x,y,wt);
	}
//		n = 6;
//		GraphReach Graph = new GraphReach(n);
//		Graph.addEdge(0,1,10);
//		Graph.addEdge(0,2,8);
//		Graph.addEdge(1,2,6);
//		Graph.addEdge(2,3,4);
//		Graph.addEdge(4,5,6);
//		Graph.addEdge(5,4,10);

	System.out.println(Graph);

	System.out.print("Pairs of vertices to test: ");
	x = scan.nextInt();
	y = scan.nextInt();
	while(x>=0 && x < n && y>=0 && y < n) { // exit if vertex does not exist
	    test = Graph.reach(x,y);
	    if(test) {
		System.out.println("We can get from " + x + " to " + y + "\n");
	    }
	    else {
		System.out.println("We cannot get from " + x + " to " + y + "\n");
	    }
	    x = scan.nextInt();
	    y = scan.nextInt();
	}

    }

}
