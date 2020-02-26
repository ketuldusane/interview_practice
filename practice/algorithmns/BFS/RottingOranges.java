package algorithmns.BFS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Rotting Oranges
 * <p>
 * Company: Amazon
 * <p>
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
 * return -1 instead.
 * <p>
 * Example 1:
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens
 * 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */

public class RottingOranges {
  public int orangesRotting(int[][] grid) {
    int fresh = 0;
    int time = 0;
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, -1, 0, 1};
    Deque<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[]{i, j});
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }
    if (queue.isEmpty() && fresh == 0) {
      return 0;
    }
    while (!queue.isEmpty()) {
      time++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] loc = queue.poll();
        for (int k = 0; k < 4; k++) {
          int a = loc[0] + x[k];
          int b = loc[1] + y[k];
          if (isValid(grid, a, b) && grid[a][b] == 1) {
            grid[a][b] = 2;
            queue.offer(new int[]{a, b});
            fresh--;
          }
        }
      }
    }
    if (fresh != 0) {
      return -1;
    }
    return time - 1;
  }

  private boolean isValid(int[][] grid, int i, int j) {
    return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[0].length);
  }
}
