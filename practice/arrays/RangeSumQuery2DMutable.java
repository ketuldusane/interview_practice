package arrays;

/**
 * Range Sum Query 2D - Mutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * Note:
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2DMutable {
  int[][] sumarr;
  int[][] mat;

  int m;
  int n;

  public RangeSumQuery2DMutable(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    mat = matrix;
    m = mat.length;
    n = mat[0].length;

    sumarr = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sumarr[i][j] = mat[i][j];
        if (i > 0) {
          sumarr[i][j] += sumarr[i - 1][j];
        }
      }
    }
  }

  public void update(int row, int col, int val) {
    if (row < 0 || row >= m || col < 0 || col >= n) {
      return;
    }
    mat[row][col] = val;
    for (int i = row; i < m; i++) {
      int sum = 0;
      if (i > 0) {
        sum = sumarr[i - 1][col];
      }
      sumarr[i][col] = mat[i][col] + sum;
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 < 0 || row1 >= m || col1 < 0 || col1 >= n) {
      return 0;
    }
    if (row2 < 0 || row2 >= m || col2 < 0 || col2 >= n) {
      return 0;
    }
    int sum = 0;
    for (int j = col1; j <= col2; j++) {
      sum += sumarr[row2][j];
      if (row1 > 0) {
        sum -= sumarr[row1 - 1][j];
      }
    }
    return sum;
  }
}
