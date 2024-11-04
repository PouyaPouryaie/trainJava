package basictrain.codetrain.leetcode.algorithm1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS / BFS
 * 542. 01 Matrix
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 */
public class ZEROANDONEMatrix {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = updateMatrix(mat);
        System.out.println("finish");
    }

    public static int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return matrix;

        Queue<int[]> q = new LinkedList<>();
        int rows = matrix.length, cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        int distance = 0;
        int[][] moves = {{0,1}, {0,-1}, {-1,0}, {1, 0}};
        while(!q.isEmpty()) {
            distance++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.remove();
                for(int[] move : moves) {
                    int x = pos[0] + move[0];
                    int y = pos[1] + move[1];
                    if(x >= 0 && x < rows &&  y >= 0 && y < cols && matrix[x][y] == -1){
                        q.add(new int[]{x,y});
                        matrix[x][y] = distance;
                    }
                }
            }
        }
        return matrix;
    }
}
