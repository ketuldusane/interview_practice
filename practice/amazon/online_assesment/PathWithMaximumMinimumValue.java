package amazon.online_assesment;

import java.util.PriorityQueue;

/**
 * Path With Maximum Minimum Value
 * <p>
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 * <p>
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 * <p>
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation:
 * The path with the maximum score is highlighted in yellow.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */

public class PathWithMaximumMinimumValue {
  public int maximumMinimumPath(int[][] A) {
    boolean[][] visited = new boolean[A.length][A[0].length];
    PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> (b.val - a.val));
    return searchPath(A, queue, visited);
  }

  private int searchPath(int[][] grid, PriorityQueue<Cell> queue, boolean[][] visited) {
    int min = Integer.MAX_VALUE;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    queue.offer(new Cell(0, 0, grid[0][0]));
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      Cell c = queue.poll();
      min = Math.min(c.val, min);
      if (c.i == grid.length - 1 && c.j == grid[0].length - 1) {
        return min;
      }
      for (int k = 0; k < dirs.length; k++) {
        int ni = c.i + dirs[k][0];
        int nj = c.j + dirs[k][1];
        if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && !visited[ni][nj]) {
          queue.offer(new Cell(ni, nj, grid[ni][nj]));
          visited[ni][nj] = true;
        }
      }
    }
    return -1;
  }

  class Cell {
    int i;
    int j;
    int val;

    Cell(int x, int y, int v) {
      i = x;
      j = y;
      val = v;
    }
  }
}
