package algoritmns.dynamic_programming_recursion;

/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    // Solve it using dp
    // TC: O(n2)
    int m = grid.length;
    int n = grid[0].length;
    for (int j = n - 2; j >= 0; j--) {
      grid[m - 1][j] += grid[m - 1][j + 1];
    }
    for (int i = m - 2; i >= 0; i--) {
      grid[i][n - 1] += grid[i + 1][n - 1];
    }
    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
      }
    }
    return grid[0][0];
  }
}
