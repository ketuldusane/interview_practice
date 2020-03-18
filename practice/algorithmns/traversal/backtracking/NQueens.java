package algorithmns.traversal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-Queens
 * <p>
 * n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 * <p>
 * Example:
 * Input: 4
 * Output: [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */

public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    if (n < 1) {
      return ans;
    }

    char[][] grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(grid[i], '.');
    }

    solve(ans, grid, 0);
    return ans;
  }

  private void solve(List<List<String>> ans, char[][] grid, int row) {
    // found solution
    if (row == grid.length) {
      ans.add(build(grid));
      return;
    }

    for (int i = 0; i < grid.length; i++) {
      grid[row][i] = 'Q';
      if (isValid(grid, row, i)) {
        solve(ans, grid, row + 1);
      }
      grid[row][i] = '.';
    }
  }

  private boolean isValid(char[][] grid, int x, int y) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < grid.length; j++) {
        if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && grid[i][j] == 'Q') {
          return false;
        }
      }
    }
    return true;
  }

  private List<String> build(char[][] grid) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < grid[0].length; j++) {
        sb.append(grid[i][j]);
      }
      list.add(sb.toString());
    }
    return list;
  }
}
