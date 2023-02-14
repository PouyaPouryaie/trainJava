//********************************
// Voting.java
//********************************
package graph.ex4;

public class Voting {
    int rows, cols;
    int Grid[][];

    public Voting(int n, int m) {
        rows = n;
        cols = m;

        Grid = new int[n][m];

    }

    public void addRank(int item, int voter, int place) {

        Grid[item][voter] = place;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += Grid[i][j] + "\t";
            }
            result += "\n";
        }
        return result;

    }

}
