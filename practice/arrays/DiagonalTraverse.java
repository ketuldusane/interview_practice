package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */

public class DiagonalTraverse {
  public int[] findDiagonalOrder(int[][] matrix) {
    return usingArray(matrix);
  }

  private int[] usingArray(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int row = 0;
    int col = 0;
    int[] ans = new int[m * n];

    for (int i = 0; i < m * n; i++) {
      // (row + col) % 2 = 0 for up direction always

      ans[i] = matrix[row][col];

      if ((row + col) % 2 == 0) {
        if (col == n - 1) {
          row++;
        } else if (row == 0) {
          col++;
        } else {
          row--;
          col++;
        }
      } else {
        if (row == m - 1) {
          col++;
        } else if (col == 0) {
          row++;
        } else {
          row++;
          col--;
        }
      }
    }

    return ans;
  }

  private int[] usingReverseLists(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      List<Integer> a = new ArrayList<>();
      dfs(matrix, i, 0, a);
      ans.add(a);
    }
    for (int j = 1; j < matrix[0].length; j++) {
      List<Integer> a = new ArrayList<>();
      dfs(matrix, matrix.length - 1, j, a);
      ans.add(a);
    }
    List<Integer> sol = new ArrayList<>();
    for (int i = 0; i < ans.size(); i++) {
      List<Integer> a = ans.get(i);
      if (i % 2 == 0) {
        sol.addAll(a);
      } else {
        Collections.reverse(a);
        sol.addAll(a);
      }
    }
    int[] m = new int[sol.size()];
    for (int i = 0; i < m.length; i++) {
      m[i] = sol.get(i);
    }
    return m;
  }

  private void dfs(int[][] mat, int i, int j, List<Integer> a) {
    if (isValid(mat, i, j)) {
      a.add(mat[i][j]);
      dfs(mat, i - 1, j + 1, a);
    }
  }

  private boolean isValid(int[][] mat, int i, int j) {
    return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length;
  }
}
