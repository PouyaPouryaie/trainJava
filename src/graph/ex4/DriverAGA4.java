//********************************
// DriverAGA4.java
// Driver for Assignment 4
//********************************
package graph.ex4;

import java.util.Scanner;

public class DriverAGA4 {

    public static void main(String[] args) {
        int n, m, x;

        Scanner scan = new Scanner(System.in);
        System.out.print("number of voters: ");
        m = scan.nextInt();
        System.out.print("number of candidates: ");
        n = scan.nextInt();

        Prefs Rankings = new Prefs(n, m);
        System.out.println("For each voter, list the candidates in order of preference.");

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                x = scan.nextInt();
//                Rankings.addRank(x, i, j);
//            }
//        }

        Rankings.addRank(0, 0, 0);
        Rankings.addRank(1, 0, 1);
        Rankings.addRank(2, 0, 2);

        Rankings.addRank(0, 1, 2);
        Rankings.addRank(1, 1, 1);
        Rankings.addRank(2, 1, 0);

        Rankings.addRank(0, 2, 0);
        Rankings.addRank(1, 2, 2);
        Rankings.addRank(2, 2, 1);

        Rankings.addRank(0, 3, 1);
        Rankings.addRank(1, 3, 2);
        Rankings.addRank(2, 3, 0);

        System.out.println(Rankings);

        Rankings.prefList();

    }

}
