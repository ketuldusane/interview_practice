package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Number of Distinct Islands
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can
 * be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */

public class NumberOfDistinctIslands {
  private boolean[][] seen;
  private ArrayList<Integer> path;

  public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    seen = new boolean[m][n];
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        path = new ArrayList<>();
        find(grid, i, j, 0);
        if (!path.isEmpty()) {
          set.add(path);
        }
      }
    }
    return set.size();
  }

  private void find(int[][] grid, int i, int j, int d) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !seen[i][j]) {
      seen[i][j] = true;
      path.add(d);
      find(grid, i - 1, j, 1);
      find(grid, i + 1, j, 2);
      find(grid, i, j - 1, 3);
      find(grid, i, j + 1, 4);
      path.add(0);
    }
  }
}
