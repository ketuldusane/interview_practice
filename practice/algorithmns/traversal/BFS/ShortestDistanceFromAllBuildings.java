package algorithmns.traversal.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Shortest Distance From All Buildings
 * <p>
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can
 * only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to above rules, return -1.
 */

public class ShortestDistanceFromAllBuildings {
  // Apply standard BFS
  // Instead of searching from '0' and trying to reach '1',
  // search from '1' and fill up a 2D array with distances to 0
  // The '0' index with min distance in the 2D array is the answer

  public int shortestDistance(int[][] grid) {
    if (grid == null || grid[0].length == 0) {
      return -1;
    }

    int[][] distances = new int[grid.length][grid[0].length];
    int[][] reach = new int[grid.length][grid[0].length];
    int numOfHouses = 0;
    int distance = Integer.MAX_VALUE;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          bfs(grid, i, j, distances, reach);
          numOfHouses++;
        }
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0 && reach[i][j] == numOfHouses) {
          distance = Math.min(distances[i][j], distance);
        }
      }
    }

    return distance == Integer.MAX_VALUE ? -1 : distance;
  }

  private void bfs(int[][] grid, int i, int j, int[][] distances, int[][] reach) {
    int distance = 1;
    Deque<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    queue.offer(new int[]{i, j});
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        int[] current = queue.poll();
        for (int[] neighbor : getNeighbors(grid, current)) {
          int x = neighbor[0];
          int y = neighbor[1];
          if (!visited[x][y]) {
            reach[x][y] += 1;
            visited[x][y] = true;
            distances[x][y] += distance;
            queue.offer(neighbor);
          }
        }
      }
      distance++;
    }
  }

  private List<int[]> getNeighbors(int[][] grid, int[] current) {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    List<int[]> neighbors = new ArrayList<>();

    for (int[] direction : directions) {
      int i = current[0] + direction[0];
      int j = current[1] + direction[1];
      if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0) {
        neighbors.add(new int[]{i, j});
      }
    }

    return neighbors;
  }
}
