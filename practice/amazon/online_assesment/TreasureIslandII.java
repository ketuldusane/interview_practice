package amazon.online_assesment;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Treasure Island II
 * <p>
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous
 * reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out
 * a shortest route to one of the treasure islands.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the
 * starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island
 * is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You
 * cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to get to any of the
 * treasure islands.
 * <p>
 * Example:
 * <p>
 * Input:
 * [['S', 'O', 'O', 'S', 'S'],
 * ['D', 'O', 'D', 'O', 'D'],
 * ['O', 'O', 'O', 'O', 'X'],
 * ['X', 'D', 'D', 'O', 'O'],
 * ['X', 'D', 'D', 'D', 'O']]
 * <p>
 * Output: 3
 * Explanation:
 * You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest
 * route is (0, 3), (1, 3), (2, 3), (2, 4).
 */

public class TreasureIslandII {
  public static void main(String[] args) {
    char[][] island = new char[][]{
        {'S', 'O', 'O', 'S'},
        {'D', 'O', 'D', 'O'},
        {'X', 'O', 'O', 'O'},
        {'O', 'D', 'D', 'X'}
    };
    System.out.println(new TreasureIslandII().treasureIsland(island));
  }

  // This example makes use of multi source BFS
  public int treasureIsland(char[][] island) {
    // Ruling out base error conditions
    if (island == null || island.length == 0) {
      return 0;
    }

    boolean[][] visited = new boolean[island.length][island[0].length];
    Deque<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < island.length; i++) {
      for (int j = 0; j < island[0].length; j++) {
        if (island[i][j] == 'S') {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }

    return search(island, queue, visited);
  }

  private int search(char[][] island, Deque<int[]> queue, boolean[][] visited) {
    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int steps = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] loc = queue.poll();
        if (island[loc[0]][loc[1]] == 'X') {
          return steps;
        }

        for (int[] dir : direction) {
          int x = loc[0] + dir[0];
          int y = loc[1] + dir[1];

          if (isValidAndSafe(island, x, y) && !visited[x][y]) {
            visited[x][y] = true;
            queue.offer(new int[]{x, y});
          }
        }
      }
      steps++;
    }

    return 0;
  }

  private boolean isValidAndSafe(char[][] grid, int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 'D';
  }
}
