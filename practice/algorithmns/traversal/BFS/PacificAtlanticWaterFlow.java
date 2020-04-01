package algorithmns.traversal.BFS;

import java.util.*;

/**
 * Pacific Atlantic Waterflow
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific
 * ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * Example:
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

public class PacificAtlanticWaterFlow {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> ans = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return ans;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    int[][] pacific = new int[m][n];
    int[][] atlantic = new int[m][n];

    Deque<int[]> pQueue = new ArrayDeque<>();
    Deque<int[]> aQueue = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      pQueue.offer(new int[]{i, 0});
      aQueue.offer(new int[]{i, n - 1});
    }

    for (int j = 0; j < n; j++) {
      pQueue.offer(new int[]{0, j});
      aQueue.offer(new int[]{m - 1, j});
    }

    bfs(matrix, pQueue, pacific);
    bfs(matrix, aQueue, atlantic);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
          ans.add(Arrays.asList(i, j));
        }
      }
    }

    return ans;
  }

  private void bfs(int[][] matrix, Deque<int[]> queue, int[][] visited) {
    int[] x = new int[]{-1, 0, 1, 0};
    int[] y = new int[]{0, -1, 0, 1};

    while (!queue.isEmpty()) {
      int[] loc = queue.poll();
      visited[loc[0]][loc[1]] = 1;

      for (int i = 0; i < 4; i++) {
        int a = loc[0] + x[i];
        int b = loc[1] + y[i];

        if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[0].length && visited[a][b] != 1 && matrix[a][b] >= matrix[loc[0]][loc[1]]) {
          queue.offer(new int[]{a, b});
        }
      }
    }
  }
}
