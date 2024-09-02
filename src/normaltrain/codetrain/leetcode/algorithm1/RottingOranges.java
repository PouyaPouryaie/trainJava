package normaltrain.codetrain.leetcode.algorithm1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS / BFS
 * 994. Rotting Oranges
 * <p>
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] mat = {{0, 0, 0, 0}};
        int time = orangesRotting(mat);
        System.out.println("oranges rotting time elapsed is " + time);
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList();
        int r = grid.length, c = grid[0].length, fresh = 0, t = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == 2) rotten.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        while (!rotten.isEmpty()) {
            int num = rotten.size();
            for (int i = 0; i < num; ++i) {
                int x = rotten.peek()[0], y = rotten.peek()[1];
                rotten.remove();
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    rotten.add(new int[]{x - 1, y});
                }
                ;
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    rotten.add(new int[]{x, y - 1});
                }
                ;
                if (x < r - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    rotten.add(new int[]{x + 1, y});
                }
                ;
                if (y < c - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    rotten.add(new int[]{x, y + 1});
                }
                ;
            }
            if (!rotten.isEmpty()) t++;
        }
        return (fresh == 0) ? t : -1;
    }
}
