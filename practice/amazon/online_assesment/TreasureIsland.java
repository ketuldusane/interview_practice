package amazon.online_assesment;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Treasure Island
 * <p>
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous
 * reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out
 * a shortest route to the treasure island.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the
 * top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as
 * X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be
 * marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in.
 * The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
 * <p>
 * Example:
 * <p>
 * Input:
 * [['O', 'O', 'O', 'O'],
 * ['D', 'O', 'D', 'O'],
 * ['O', 'O', 'O', 'O'],
 * ['X', 'D', 'D', 'O']]
 * <p>
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */

public class TreasureIsland {
  public static void main(String[] args) {
    char[][] island = new char[][]{
        {'O', 'O', 'O', 'O'},
        {'D', 'O', 'D', 'O'},
        {'O', 'O', 'O', 'O'},
        {'O', 'D', 'D', 'X'}
    };
    System.out.println(new TreasureIsland().treasureIsland(island));
  }

  public int treasureIsland(char[][] island) {
    if (island == null || island.length == 0) {
      return 0;
    }

    // target = 'X'
    // Danger = 'D'

    return search(island);
  }

  private int search(char[][] island) {
    // We can make use of BFS
    int steps = 0;
    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean[][] visited = new boolean[island.length][island[0].length];
    Queue<int[]> queue = new ArrayDeque<>();

    queue.offer(new int[]{0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] loc = queue.poll();
        if (island[loc[0]][loc[1]] == 'X') {
          return steps;
        }

        for (int k = 0; k < 4; k++) {
          int x = loc[0] + direction[k][0];
          int y = loc[1] + direction[k][1];

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

  private boolean isValidAndSafe(char[][] island, int x, int y) {
    return x >= 0 && x < island.length && y >= 0 && y < island[0].length && island[x][y] != 'D';
  }
}
