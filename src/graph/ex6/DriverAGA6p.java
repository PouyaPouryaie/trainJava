//********************************
// DriverAGA6p.java
//********************************
package graph.ex6;

import java.util.Scanner;

public class DriverAGA6p
{
    
    public static void main(String[] args)
    {
	int n, m, x, y, p;
	Projects proj;
	int select[];


	Scanner scan = new Scanner(System.in);
	System.out.print("Number of projects: ");
	n = scan.nextInt();
	proj = new Projects(n);
	System.out.println("Enter profit of each project");
	for(int i=0;i<n;i++) {
	    p = scan.nextInt();
	    proj.addProfit(i,p);
	}
	System.out.print("Number of prerequisites: ");
	m = scan.nextInt();
	System.out.println("Enter prerequisite pairs (index of earlier project and index of later project):");
	for(int i=0;i<m;i++) {
	    x = scan.nextInt();
	    y = scan.nextInt();
	    proj.addPrereq(x,y);
	}
	
	select = proj.projSelect();

	System.out.print("Projects to be done:");
	for(int i=0;i<n;i++) {
	    if(select[i] == 1) {
		System.out.print(" "+i);
	    }
	}
	System.out.print("\n");
    }   

}
