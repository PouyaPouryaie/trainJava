package basictrain.codetrain.javaproblem.ds;

import java.util.Scanner;

/**
 * address of problem : https://www.hackerrank.com/challenges/java-1d-array/problem
 */
public class Java1DArrayPart2 {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return isSolve(leap, game, 0);
    }

    public static boolean isSolve(int leap, int[] game, int i){

        if(i < 0 || game[i] == 1){
            return false;
        }
        else if(i >= game.length){
            return true;
        }

        game[i] = 1;

        return isSolve(leap, game, i + leap) ||
                isSolve(leap, game, i + 1) ||
                isSolve(leap, game, i-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
