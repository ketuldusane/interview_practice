package algorithmns.traversal.backtracking;

import java.util.Arrays;

/**
 * Longest Increasing Path In Matrix

   Given an integer matrix, find the length of the longest increasing path.

   From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

   Example 1:

   Input: nums =
   [
   [9,9,4],
   [6,6,8],
   [2,1,1]
   ]
   Output: 4
   Explanation: The longest increasing path is [1, 2, 6, 9].
   Example 2:

   Input: nums =
   [
   [3,4,5],
   [3,2,6],
   [2,2,1]
   ]
   Output: 4
   Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

public class LongestIncreasingPathInMatrix {
  private int max = 1;

  // Use backtracking with memoization
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int[][] memo = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      Arrays.fill(memo[i], -1);
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (memo[i][j] == -1) {
          backtrack(matrix, i, j, 1, memo);
        }
      }
    }
    return max;
  }

  private void backtrack(int[][] m, int i, int j, int len, int[][] memo) {
    memo[i][j] = 1;

    int[] x = {-1, 0, 1, 0};
    int[] y = {0, -1, 0, 1};

    for (int d = 0; d < 4; d++) {
      int ni = i + x[d];
      int nj = j + y[d];
      if (isValid(m, ni, nj) && m[ni][nj] > m[i][j]) {
        if (memo[ni][nj] == -1) {
          backtrack(m, ni, nj, len + 1, memo);
        }
        memo[i][j] = Math.max(memo[i][j], memo[ni][nj] + 1);
        max = Math.max(max, memo[i][j]);
      }
    }
  }

  private boolean isValid(int[][] m, int i, int j) {
    return (i >= 0 && i < m.length) && (j >= 0 && j < m[0].length);
  }
}
