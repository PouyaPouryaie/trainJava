package graph.ex9;
//********************************
// DriverAGA9c.java
//********************************

import java.util.Scanner;

public class DriverAGA9c
{
    
    public static void main(String[] args)
    {
	int n, m, x, y, t;
	int [][] simscores;
	int [][] matrix;
	float limit;


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of items: ");
	n = scan.nextInt();
	simscores = new int[n][n];
	for(int i=0;i<n-1;i++) {
	    for(int j=i+1;j<n;j++) {
		System.out.print(i+" to "+j+" similarity:");
		simscores[i][j] = scan.nextInt();
	    }
	}
	System.out.print("\n");


	for(int i=0;i<n-1;i++) {
	    for(int j=1;j<n;j++) {
		System.out.print("\t");
		if(i<j) {
		    System.out.print(simscores[i][j]);
		}
	    }
	    System.out.print("\n");
	}

	System.out.print("Enter similarity threshold:");
	t = scan.nextInt();
	System.out.print("\n");


	m = 0;
	matrix = new int[n][n];
	for(int i=0;i<n;i++) {
	    for(int j=0;j<n;j++) {
		matrix[i][j] = 0;
		if(i<j && simscores[i][j] >= t) {
		    matrix[i][j] = 1;
		    m++;
		}
	    }
	}
	for(int i=0;i<n-1;i++) {
	    for(int j=1;j<n;j++) {
		System.out.print("\t");
		if(i<j) {
		    System.out.print(matrix[i][j]);
		}
	    }
	    System.out.print("\n");
	}


	EBetween Graph = new EBetween(n,m);

	for(int i=0;i<n-1;i++) {
	    for(int j=i+1;j<n;j++) {
		if(matrix[i][j]==1) {
		    Graph.addEdge(i,j);
		}
	    }
	}
	
	Graph.betFind();
	
	System.out.println(Graph);

	System.out.print("Enter upper limit on betweenness:");
	limit=scan.nextFloat();
	System.out.print("\n");
	
	Graph.cluster(limit);
	
	System.out.println(Graph);

	
    }   

}
