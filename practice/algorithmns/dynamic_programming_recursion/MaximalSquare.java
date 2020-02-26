package algorithmns.dynamic_programming_recursion;

/**
 * Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int maxSq = 0;
    int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
    for (int i = 1; i <= matrix.length; i++) {
      for (int j = 1; j <= matrix[0].length; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          maxSq = Math.max(maxSq, dp[i][j]);
        }
      }
    }
    return maxSq * maxSq;
  }
}
