package arrays;

/**
 * Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
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
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2DImmutable {
  private int[][] rows;
  private int m = 0;
  private int n = 0;

  public RangeSumQuery2DImmutable(int[][] matrix) {
    if (matrix != null && matrix.length > 0 && matrix[0].length> 0) {
      m = matrix.length;
      n = matrix[0].length;
      rows = new int[m][n];
      fillRows(matrix);
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int ans = 0;
    if (row1 < 0 || row1 >= m || col1 < 0 || col1 >= n || row2 < 0 || row2 >= m || col2 < 0 || col2 >= n) {
      return ans;
    }
    for (int i = row1; i <= row2; i++) {
      ans += rows[i][col2];
      if (col1 > 0) {
        ans -= rows[i][col1 - 1];
      }
    }
    return ans;
  }

  private void fillRows(int[][] matrix) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          rows[i][j] = matrix[i][j];
        } else {
          rows[i][j] = matrix[i][j] + rows[i][j - 1];
        }
      }
    }
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */