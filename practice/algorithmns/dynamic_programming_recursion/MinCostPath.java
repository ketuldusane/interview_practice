package algorithmns.dynamic_programming_recursion;

/**
 * Min Cost path
 *
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 * For example, in the following figure, what is the minimum cost path to (2, 2)
 * The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).
 */

public class MinCostPath {
  public int minCost(int cost[][], int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = cost[0][0];

    for (int i = 1; i <= m; i++) {
      dp[i][0] = dp[i - 1][0] + cost[i][0];
    }

    for (int j = 1; j <= m; j++) {
      dp[0][j] = dp[0][j - 1] + cost[0][j];
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + cost[i][j];
      }
    }

    return dp[m][n];
  }

  public static void main(String args[]) {
    int cost[][] = { {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3} };

    System.out.print(new MinCostPath().minCost(cost, 2, 2));
  }

}
