package amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Zombie In Matrix
 * <p>
 * Amazon Online Assessment
 * <p>
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human
 * beings into zombies every hour. Find out how many hours does it take to infect all humans?
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0, 1, 1, 0, 1],
 * [0, 1, 0, 1, 0],
 * [0, 0, 0, 0, 1],
 * [0, 1, 0, 0, 0]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [0, 1, 0, 1, 1],
 * [1, 1, 1, 0, 1]]
 * <p>
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1]]
 */

public class ZombieInMatrix {
  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(0, 1, 1, 0, 1));
    list.add(Arrays.asList(0, 1, 0, 1, 0));
    list.add(Arrays.asList(0, 0, 0, 0, 1));
    list.add(Arrays.asList(0, 1, 0, 0, 0));

    ZombieInMatrix z = new ZombieInMatrix();
    System.out.println(z.minHours(list.size(), list.get(0).size(), list));
  }

  public int minHours(int rows, int columns, List<List<Integer>> grid) {
    if (grid == null || grid.size() == 0) {
      return -1;
    }

    int count = 0;
    int totalElements = 0;
    Deque<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < grid.size(); i++) {
      totalElements += grid.get(i).size();
      for (int j = 0; j < grid.get(i).size(); j++) {
        if (grid.get(i).get(j) == 1) {
          count++;
          queue.offer(new int[]{i, j});
        }
      }
    }

    return bfs(grid, queue, count, totalElements);
  }

  private int bfs(List<List<Integer>> grid, Deque<int[]> queue, int count, int totalElements) {
    int time = 0;
    int[] x = new int[]{-1, 0, 1, 0};
    int[] y = new int[]{0, -1, 0, 1};

    while (!queue.isEmpty()) {
      if (count < totalElements) {
        time++;
      }
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] loc = queue.poll();
        for (int k = 0; k < 4; k++) {
          int nx = loc[0] + x[k];
          int ny = loc[1] + y[k];

          if (isValid(grid, nx, ny) && grid.get(nx).get(ny) == 0) {
            grid.get(nx).set(ny, 1);
            queue.offer(new int[]{nx, ny});
            count++;
          }
        }
      }
    }

    return count == totalElements ? time : -1;
  }

  private boolean isValid(List<List<Integer>> grid, int x, int y) {
    return x >= 0 && x < grid.size() && y >= 0 && y < grid.get(x).size();
  }
}
